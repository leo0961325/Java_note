package com.example.nba.demo.service.IMP;


import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.enums.ErrorEnum;
import com.example.nba.demo.model.Game;
import com.example.nba.demo.model.Player;
import com.example.nba.demo.model.Status;
import com.example.nba.demo.model.Team;
import com.example.nba.demo.nbaRequest.GameRequest;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.PlayerGameResponse;
import com.example.nba.demo.nbaResponse.QueryPlayerResponse;
import com.example.nba.demo.nbaResponse.ResultResponse;
import com.example.nba.demo.repository.*;
import com.example.nba.demo.service.IMP.Methods.MethodService;
import com.example.nba.demo.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService extends MethodService implements ITeamService {


    @Autowired
    IGameRepository iGameRepository;

    @Autowired
    IPlayerRepositroy iPlayerRepositroy;

    @Autowired
    ITeamRepository iTeamRepository;

    @Autowired
    IStatusRepository iStatusRepository;

    /**
     * 使用requestbody輸入
     * 先輸入的TeamId 就是贏的那一方
     * 並同時同步 win and lose
     *
     * @param gameRequest
     * @param TeamId
     * @return
     * @throws Exception
     */
    @Override
    public ResultResponse addGameResult(GameRequest gameRequest, List<Integer> TeamId) throws NbaException {

        List<Team> findTeams = iTeamRepository.findAllById(TeamId);

        checkTeamListIdExist(TeamId);
        checkPlayerIfNotExist(gameRequest.getMvp());

        String homeTeam = gameRequest.getHome();
        String guestTem = gameRequest.getGuest();
        if (homeTeam.equals(guestTem)) {
            throw new NbaException(ErrorEnum.ERROR_ENTER, "You Enter the same team id ");
        }

        Game game = new Game(gameRequest);

        for (Team team : findTeams) {
            if (team.getId().equals(TeamId.get(0))) {

                /**設置累加 在第46行 ， 要把原本的取出來*/
                Integer winTeam = 0;
                winTeam += 1;
                team.setWin(team.getWin() + winTeam);

            }
            if (team.getId().equals(TeamId.get(1))) {

                Integer loseTeam = 0;
                loseTeam += 1;
                team.setLose(team.getLose() + loseTeam);
            }

            iTeamRepository.save(team);
        }

        game.setTeams(findTeams);

        iGameRepository.save(game);


        return new ResultResponse(game);
    }


    /**
     * 修改 如果隊伍勝負出錯
     *
     * @param teamId
     * @param win
     * @param lose
     * @return
     */

    @Override
    public String editGameResult(Integer teamId, Integer win, Integer lose) throws NbaException {


        Optional<Team> findTeam = iTeamRepository.findById(teamId);
        checkTeamExist(teamId);

        Team team = findTeam.get();

        team.setWin(win);
        team.setLose(lose);


        iTeamRepository.save(team);


        return "已經更改" + team.getTeamName() + "勝負為: \nwin: " + win + "\nlose: " + lose;
    }


    /**
     * 使用 Id 輸入絕對值 post result
     *
     * @param homeId
     * @param guestId
     * @param mvpId
     * @param resultTeamId
     * @return
     * @throws Exception
     */
    @Override
    public ResultResponse addGameResultById(Integer homeId, Integer guestId, Integer mvpId, Integer resultTeamId) throws NbaException {

        Team findTeam = iTeamRepository.findAllById(resultTeamId);
        Team homeTeam = iTeamRepository.findAllById(homeId);
        Team guestTeam = iTeamRepository.findAllById(guestId);


        Player mvpPlayer = iPlayerRepositroy.findNameById(mvpId);
        /**
         * 查看有沒有這球員
         */
        checkPlayerById(mvpId);
        /**
         * 查看這球星有沒有健康的
         */
        checkPlayerMustHealthy(mvpId);

        /**
         * 查看MVP球員是否有在兩個隊伍裡面
         */
        List<Team> teamList = new ArrayList<>();
        teamList.add(homeTeam);
        teamList.add(guestTeam);


        List<Integer> teamIds = new ArrayList<>();
        for (Team team : teamList) {
            teamIds.add(team.getId());
        }
        if (!teamIds.contains(mvpPlayer.getTeam().getId())) {


            throw new NbaException(ErrorEnum.ERROR_NOTFOUND_PLAYER, mvpPlayer.getName() + "不在該比賽隊伍裡面");

        }
        /**
         * 贏的隊伍才有MVP阿
         */
        if (!mvpPlayer.getTeam().getId().equals(resultTeamId)) {
            throw new NbaException(ErrorEnum.ERROR_ENTER, "贏的隊伍才有MVP阿");
        }
        /**
         * 判斷是否輸入相同隊伍
         */
        if (homeId.equals(guestId)) {
            throw new NbaException(ErrorEnum.ERROR_ENTER, "You Enter the same group , plz modify it");
        }

        /**
         * check Teams exists
         */
        checkTeamExist(resultTeamId);
        /**
         * check player exist
         */
        checkPlayerById(mvpId);
        /**
         * check if same Team
         */
        checkSameTeam(homeId, guestId);


        Game game = new Game();

        game.setHome(homeTeam.getTeamName());
        game.setGuest(guestTeam.getTeamName());
        game.setMvp(mvpPlayer.getName());


        /**
         * 勝負的判斷式
         * 首先看home id 是否等於 勝利的隊伍
         */
        if (homeTeam.getId().equals(resultTeamId)) {
            for (Team team : teamList) {
                if (team.getId().equals(homeTeam.getId())) {

                    /**設置累加*/
                    Integer winTeam = 0;
                    winTeam += 1;
                    team.setWin(team.getWin() + winTeam);
                    game.setWinTeam(team.getTeamName());


                }
                if (team.getId().equals(guestTeam.getId())) {

                    Integer loseTeam = 0;
                    loseTeam += 1;
                    team.setLose(team.getLose() + loseTeam);
                }
            }
        } else {
            for (Team team : teamList) {
                if (team.getId().equals(guestTeam.getId())) {

                    /**設置累加*/
                    Integer winTeam = 0;
                    winTeam += 1;
                    team.setWin(team.getWin() + winTeam);
                    game.setWinTeam(team.getTeamName());


                }
                if (team.getId().equals(homeTeam.getId())) {

                    Integer loseTeam = 0;
                    loseTeam += 1;
                    team.setLose(team.getLose() + loseTeam);
                }
            }
        }


        iTeamRepository.save(findTeam);

        game.setTeams(teamList);

        iGameRepository.save(game);

        return new ResultResponse(game);
    }

    /**
     * 修改球員參加 該場球賽的紀錄
     *
     * @param players
     * @param gameId
     * @return
     * @throws NbaException
     */
    @Override
    public PlayerGameResponse modifyPlayerAndGame(List<Integer> players, List<Integer> gameId) throws NbaException {
        List<Player> playerList = iPlayerRepositroy.findAllByIdIn(players);


        List<Game> gameList = iGameRepository.findAllByIdIn(gameId);


        checkPlayerIdExist(players);
        checkGameListIdExist(gameId);


        /**
         * 新增或是更新 如果不再裡面就更新
         *
         */

        for (Player player : playerList) {
            List games = player.getGames();

            for (Game game : gameList) {
                if (!games.contains(game)) {
                    games.add(game);
                }
                List<Integer> teamIds = new ArrayList<>();

                for (Team team : game.getTeams()) {
                    teamIds.add(team.getId());
                }
                /**
                 * 這個判斷式IF要在迴圈外面，不燃他只讀到第一個。
                 */
                if (!teamIds.contains(player.getTeam().getId())) {
                    throw new NbaException(ErrorEnum.ERROR_PLAYER_IN_GAME, "Have player not in this game");
                }
            }

        }

        for (Game game : gameList) {
            for (Integer checkGameId : gameId) {
                if (!checkGameId.equals(game.getId())) {
                    throw new NbaException(ErrorEnum.ERROR_GAME_ID, "Can`t find this game No.");
                }
            }


            iGameRepository.save(game);
        }

        for (Game game : gameList) {
            PlayerGameResponse playerGameResponse = new PlayerGameResponse(game);

            return playerGameResponse;
        }
        return null;
    }


    /**
     * 查詢該隊隊員
     *
     * @param teamId
     * @param statusId
     * @return
     * @throws NbaException
     */

    @Override
    public List<QueryPlayerResponse> findteamPlayers(Integer teamId, Integer statusId) throws NbaException {

        checkTeamExist(teamId);


        List<QueryPlayerResponse> findTeamPlayers = iPlayerRepositroy.findAllByTeam_IdAndStatus_Id(teamId, statusId);
        /**
         * 先使用0找出全部
         */
        if (statusId.equals(0)) {
            List<QueryPlayerResponse> findAllTeamPlayers = iPlayerRepositroy.findAllByTeam_Id(teamId);
            return findAllTeamPlayers;
        }
        /**
         * 查詢狀態在不在
         */
        checkPlayerStatus(statusId);
        /**
         * 查看有沒有球星有這些狀態
         */
        if (findTeamPlayers.isEmpty()) {
            throw new NbaException(ErrorEnum.ERROR_EMPTY, "Non player have this Status");
        }

        return findTeamPlayers;


    }
}
