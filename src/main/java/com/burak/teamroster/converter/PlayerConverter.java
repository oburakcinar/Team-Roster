package com.burak.teamroster.converter;

import com.burak.teamroster.dto.SavePlayerRequestDto;
import com.burak.teamroster.entity.Player;
import com.burak.teamroster.entity.PlayerPosition;
import com.burak.teamroster.exception.PlayerBadRequestException;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    public Player convertPlayerDtoToPlayer(SavePlayerRequestDto savePlayerRequestDto) {
        //converting save player request dto to player entity
        Player player = new Player();
        player.setName(savePlayerRequestDto.getName());
        player.setSurname(savePlayerRequestDto.getSurname());
        player.setPlayerPosition(getPlayerPositionEnum(savePlayerRequestDto.getPlayerPosition()));
        return player;
    }

    //convert method UpdatePlayerRequestDtoToPlayer can be added in the future if needed


    private PlayerPosition getPlayerPositionEnum(String pos) {
        //helper method for converting string to player position enum.
        //if player position string is not proper, throw bad request exception
        switch (pos.toUpperCase()) {
            case ("PG"):
                return PlayerPosition.PG;
            case ("SG"):
                return PlayerPosition.SG;
            case ("SF"):
                return PlayerPosition.SF;
            case ("PF"):
                return PlayerPosition.PF;
            case ("C"):
                return PlayerPosition.C;
            default:
                throw new PlayerBadRequestException("We were unable to add new player with the provided credentials", "playerPosition");
        }
    }
}
