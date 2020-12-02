package com.example.nba.demo.service.IMP.Methods;

import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.enums.ErrorEnum;
import com.example.nba.demo.model.Game;
import com.example.nba.demo.model.Player;
import com.example.nba.demo.model.Status;
import com.example.nba.demo.model.Team;
import com.example.nba.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class MethodService {


    @Autowired
    IPlayerRepositroy iPlayerRepositroy;

    @Autowired
    IDetailRepository iDetailRepository;

    @Autowired
    IGameRepository iGameRepository;

    @Autowired
    IStatusRepository iStatusRepository;

    @Autowired
    ITeamRepository iTeamRepository;

    /**
     * 球員是否已經建檔了
     *
     * @param name
     * @throws NbaException
     */
    protected void checkPlayerExist(String name) throws NbaException {

        Optional<Player> playerExist = iPlayerRepositroy.findByName(name);
        if (playerExist.isPresent()) {
            throw new NbaException(ErrorEnum.ERROR_EXISTED_PLAYER, "球員" + name + "已經存在");
        }


        /**
         * 查看球員是否不存在
         */
    }

    protected void checkPlayerIfNotExist(String name) throws NbaException {

        Optional<Player> playerExist = iPlayerRepositroy.findByName(name);
        if (!playerExist.isPresent()) {
            throw new NbaException(ErrorEnum.ERROR_EXISTED_PLAYER, "球員" + name + "並不存在");
        }


    }


    /**
     * @param /*查看球員是否已經不再隊伍中
     * @throws NbaException
     */
    protected void checkPlayerById(Integer id) throws NbaException {

        Optional<Player> playerExist = iPlayerRepositroy.findAllById(id);
        if (!playerExist.isPresent()) {
            throw new NbaException(ErrorEnum.ERROR_NOTFOUND_PLAYER, "尋找不到球員ID : " + id);
        }


    }

    /**
     * 查看單個隊伍 id 在不在
     *
     * @param id
     * @throws NbaException
     */
    protected void checkTeamExist(Integer id) throws NbaException {

        Optional<Team> teamExist = iTeamRepository.findById(id);
        if (!teamExist.isPresent()) {
            throw new NbaException(ErrorEnum.ERROR_NOTFOUND_TEAM, "尋找不到球隊隊伍ID:" + id);
        }

    }


    /**
     * 查看多個隊伍id 在不在
     *
     * @param TeamIdList
     * @throws NbaException
     */
    protected void checkTeamListIdExist(List<Integer> TeamIdList) throws NbaException {

        List<Team> TeamsList = iTeamRepository.findByIdIn(TeamIdList);

        List<Integer> TeamIds = new ArrayList<>();
        /**
         * 型態為Team
         */
        for (Team team : TeamsList) {
            TeamIds.add(team.getId());
        }
        /**
         * 轉換型態成 interger
         */
        for (Integer tId : TeamIdList) {
            if (!TeamIds.contains(tId)) {
                throw new NbaException(ErrorEnum.ERROR_NOTFOUND_TEAM, "Team not found");
            }
        }

    }


    /**
     * 查看多個player 在不再
     *
     * @param idList
     * @throws NbaException
     */
    protected void checkPlayerIdExist(List<Integer> idList) throws NbaException {

        List<Player> playersList = iPlayerRepositroy.findAllByIdIn(idList);
        List<Integer> playersIdList = new ArrayList<>();

        for (Player player : playersList) {
            playersIdList.add(player.getId());
        }
        for (Integer pId : idList) {
            if (!playersIdList.contains(pId)) {

                throw new NbaException(ErrorEnum.ERROR_NOTFOUND_PLAYER, "Player can`t found");
            }

        }

    }


    /**
     * 查看 Games.No在不再
     *
     * @param GamesIdList
     * @throws NbaException
     */
    protected void checkGameListIdExist(List<Integer> GamesIdList) throws NbaException {

        List<Game> GamesList = iGameRepository.findAllByIdIn(GamesIdList);

        List<Integer> gamesIds = new ArrayList<>();
        /**
         * 型態為Team
         */
        for (Game game : GamesList) {
            gamesIds.add(game.getId());
        }
        /**
         *  資料庫跟輸入的看是否相符
         */

        for (Integer gId : GamesIdList) {
            if (!gamesIds.contains(gId)) {
                throw new NbaException(ErrorEnum.ERROR_NOTFOUND_TEAM, "Games number not found");
            }
        }

    }


    /**
     * 查看球員輸入狀態
     *
     * @param statusId
     * @throws NbaException
     */
    protected void checkPlayerStatus(Integer statusId) throws NbaException {

        Optional<Status> checkStatus = iStatusRepository.findById(statusId);

        if (!checkStatus.isPresent()) {
            throw new NbaException(ErrorEnum.ERROR_ENTER, "please modify enter status id");
        }


    }

    /**
     * 看是否有輸入相同的隊伍
     * @param
     * @throws NbaException
     */
    protected void checkSameTeam(Integer homeId , Integer guestId) throws NbaException {



        if(homeId.equals(guestId)){
            throw new NbaException(ErrorEnum.ERROR_ENTER , "你輸入重複的隊伍了");
        }

    }

    /**
     * 查看球星一定要是健康的
     * @param playerId
     * @throws NbaException
     */
    protected void checkPlayerMustHealthy(Integer playerId) throws NbaException {

        Optional<Player> player = iPlayerRepositroy.findAllById(playerId);
        if(!player.get().getStatus().getId().equals(1)){
            throw new NbaException(ErrorEnum.ERROR_UNHEALTHY_PLAYER,"This player isn`t Healthy,He can`t play Ball");
        }
    }
}


