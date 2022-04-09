package com.burak.teamroster.exception;

import com.burak.teamroster.dto.SavePlayerRequestDto;
import com.burak.teamroster.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.burak.teamroster.service.PlayerService.TEAM_CAPACITY;
import static org.junit.Assert.assertThrows;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExceptionTest {

    @Autowired
    private PlayerService playerService;

    @Test
    void testTeamCapacityFullException() {
        if (playerService.getAllPlayers().size() == TEAM_CAPACITY) {
            assertThrows(TeamCapacityFullException.class,
                    ()->{
                        playerService.savePlayer(new SavePlayerRequestDto("Ali", "Can", "C"));
                    });
        }
    }


    @Test
    void testPlayerBadRequestException1() {
        //if player position is not proper, it throws PlayerBadRequestException
        assertThrows(PlayerBadRequestException.class,
                ()->{
                    playerService.savePlayer(new SavePlayerRequestDto("Ali", "Can", "CCCC"));
                });
    }

    @Test
    void testPlayerBadRequestException2() {
        //if no player with the id is found, it throws PlayerBadRequestException
        assertThrows(PlayerBadRequestException.class,
                ()->{
                    playerService.deletePlayerById(240l);
                });
    }
}
