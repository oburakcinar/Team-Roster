package com.burak.teamroster.service;

import com.burak.teamroster.dto.SavePlayerRequestDto;
import com.burak.teamroster.entity.Player;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static com.burak.teamroster.service.PlayerService.TEAM_CAPACITY;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayerServiceImplTest {

    @Autowired
    private PlayerService playerService;


    @BeforeAll
    void init() {
        //saving 3 players to db before calling test methods
        playerService.savePlayer(new SavePlayerRequestDto("Ali", "Can", "C"));
        playerService.savePlayer(new SavePlayerRequestDto("Mehmet", "Dogan", "PG"));
        playerService.savePlayer(new SavePlayerRequestDto("Ayse", "Yilmaz", "PF"));
    }

    @AfterAll
    void clearPlayerList() {
        //deleting all players in the db after calling test methods
        for (Player player : playerService.getAllPlayers()) {
            playerService.deletePlayerById(player.getId());
        }
    }

    @Test
    void testFindAll() {
        Assertions.assertFalse(playerService.getAllPlayers().isEmpty());
    }

    @Test
    void testMaxTeamCapacity() {
        Assertions.assertTrue(playerService.getAllPlayers().size() <= TEAM_CAPACITY);
    }


    @Test
    void testSavePlayer() {
        Player player = playerService.savePlayer(new SavePlayerRequestDto("Ahmet", "Can", "PG"));
        List<Player> players = playerService.getAllPlayers();
        Assertions.assertTrue(players.contains(player));
    }

    @Test
    void testDeletePlayer() {
        List<Player> players = playerService.getAllPlayers();
        long playerId = players.get(0).getId();
        Player player = playerService.deletePlayerById(playerId);
        players = playerService.getAllPlayers(); //refreshing player list after deleting the player
        Assertions.assertFalse(players.contains(player));
    }

}
