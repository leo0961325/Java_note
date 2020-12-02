package com.example.nba.demo.service.IMP;


import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.enums.ErrorEnum;
import com.example.nba.demo.model.*;
import com.example.nba.demo.nbaRequest.NewRequest;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.InjuryResponse;
import com.example.nba.demo.nbaResponse.NewResponse;
import com.example.nba.demo.nbaResponse.PlayerGameResponse;
import com.example.nba.demo.repository.*;
import com.example.nba.demo.service.IMP.Methods.MethodService;
import com.example.nba.demo.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService extends MethodService implements IPlayerService {



    @Autowired
    IPlayerRepositroy iPlayerRepositroy;

    @Autowired
    IDetailRepository iDetailRepository;

    @Autowired
    ITeamRepository iTeamRepository;

    @Autowired
    IStatusRepository iStatusRepository;

    @Autowired
    IGameRepository iGameRepository;

    /**
     * 新增球員資料
     * @param newRequest
     * @return
     */
    @Override
    public String newPlayers(@Valid List<NewRequest> newRequest) throws NbaException {


        for(NewRequest newPlayers : newRequest) {

            Player player = new Player();
            Detail detail = new Detail();

            /**
             * 把狀態到資料庫先訂好
             */
            Status status = iStatusRepository.getOne(1);
            Team team = iTeamRepository.findAllById(newPlayers.getTeamId());

            List<Player> players = new ArrayList<>();
            players.add(player);

            /**看球員是否重複*/
            checkPlayerExist(newPlayers.getName());
            /**check team if exist*/
            checkTeamExist(newPlayers.getTeamId());

            player.setName(newPlayers.getName());
            /**
             * team name 用 id設置
             */
            player.setTeamName(team.getTeamName());
            player.setPosition(newPlayers.getPosition());
            player.setBacknumber(newPlayers.getBacknumber());
            player.setScore(newPlayers.getScore());



            detail.setName(newPlayers.getName());
            detail.setAge(newPlayers.getAge());
            detail.setCountry(newPlayers.getCountry());
            detail.setSalary(newPlayers.getSalary());


            team.setTeamName(team.getTeamName());

            iStatusRepository.save(status);


            player.setStatus(status);
            player.setDetail(detail);
            player.setTeam(team);

            team.setPlayers(players);
            status.setPlayers(players);


            iTeamRepository.save(team);



        }
        return "已新增球員資料";
    }

    /**
     * 球員退役API
     * @param playerId
     * @return
     */
    @Override
    public String deletePlayer(Integer playerId) throws NbaException {

        Optional<Player> findPlayer = iPlayerRepositroy.findAllById(playerId);
        /**
         * 要放在前面check是否球員已不存在
         */
        checkPlayerById(playerId);

        Player player = findPlayer.get();

        /**找到球員名字*/
        String retired = findPlayer.get().getName();
        /**
         * check球員是否已經退役。
         */

        iPlayerRepositroy.delete(player);


        return  retired + "已經退役";
    }

    /**
     * 修改球員的狀態
     * @param playerId
     * @param playerStatusId
     * @return
     * @throws Exception
     */
    @Override
    public String editPlayer(List<Integer> playerId , Integer playerStatusId) throws Exception {

        List<Player> findplayerList = iPlayerRepositroy.findAllByIdIn(playerId);
        Optional<Status> findStatus = iStatusRepository.findById(playerStatusId);

        checkPlayerIdExist(playerId);
        if (!findStatus.isPresent()){

            throw new Exception("沒有此球員狀態");
        }

        for (Player player : findplayerList){

            player.setStatus(findStatus.get());
            iPlayerRepositroy.save(player);

        }


        return "已修改球員狀態";
    }

    /**
     * 查詢負傷的隊員
     * @return
     */
    @Override
    public List<InjuryResponse> injuryPlayers() throws Exception {

        List<InjuryResponse> InjuryPlayersList = iPlayerRepositroy.findAllByStatus();

        if (InjuryPlayersList.isEmpty()){
            throw new Exception("沒有球員受傷");
        }


        return InjuryPlayersList;
    }






    /**
     * 幫球員換隊伍
     * @param playerId
     * @param teamId
     * @return
     * @throws Exception
     */

    @Override
    public String changeTeam(List<Integer> playerId, Integer teamId) throws Exception {

        List<Player> playerList = iPlayerRepositroy.findAllByIdIn(playerId);
        Optional<Team> findTeam = iTeamRepository.findById(teamId);
        Team team = iTeamRepository.findAllById(teamId);

        /**
         * 檢查隊伍跟球員在不在
         */

        checkTeamExist(teamId);
        /**
         * 檢查球員
         */
        if(playerId.size() != playerList.size()){
            throw new NbaException(ErrorEnum.ERROR_NOTFOUND_PLAYER , "have player Id not found");
        }

        for (Player player : playerList){
            /**
             * 一併更改隊伍和隊伍名字
             */
            player.setTeam(findTeam.get());
            player.setTeamName(team.getTeamName());
            iPlayerRepositroy.save(player);

        }


        return playerId.size()+"位球員已經更換隊伍至 "+team.getTeamName();
    }

    /**
     * 負傷球員重返球場
     * @param playerId
     * @return
     * @throws Exception
     */

    @Override
    public String restorePlayer(Integer playerId ) throws NbaException {

        Optional<Player> findPlayer = iPlayerRepositroy.findAllById(playerId);
        Status status = iStatusRepository.getOne(1);
        checkPlayerById(playerId);
        /**
         * 拿到該球員的資料
         */
        Player player =findPlayer.get();
        /**
         * 兩種不同的用法
         */
        if (player.getStatus().getPlayerStatus().equals("Healthy")){
            throw new NbaException(ErrorEnum.ERROR_STATUS , "This Player is healthy");
        }
        else if (player.getStatus().getId().equals(3)){

            throw new NbaException(ErrorEnum.ERROR_STATUS , "This Player is stopped in court ");
        }


        player.setStatus(status);

        iPlayerRepositroy.save(player);



        return player.getName() + "已經返回球場";
    }

    /**
     * 透過name模糊查詢找出 球員所有資料
     * @param playerName
     * @return
     */
    @Override
    public List<FindResponse> findPlayers(String playerName) throws NbaException {

        /**
         * 找出所有球員的資料
         */
        List<FindResponse>  findPlayers = iPlayerRepositroy.findAllByName(playerName);

        if (findPlayers.isEmpty()){
            throw new NbaException(ErrorEnum.ERROR_NOTFOUND_PLAYER , "找不到關鍵字相關資料球員");
        }


        return findPlayers;
    }


    /**
     * 找出 overAll score > 80 players & he is healthy
     *
     * @param
     * @return
     */
    @Override
    public List<FindResponse> pickStarPlayers(Integer score) throws NbaException {

        List<FindResponse> findSuperStar = iPlayerRepositroy.findAllByScoreIsGreaterThanEqual(score);

        if (score > 100) {
            throw new NbaException(ErrorEnum.ERROR_SCORE , "總評上限是100");
        }

        return findSuperStar;
    }




}
