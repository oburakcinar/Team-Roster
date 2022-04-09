package com.burak.teamroster.api;

import com.burak.teamroster.dto.SavePlayerRequestDto;
import com.burak.teamroster.entity.Player;
import com.burak.teamroster.service.PlayerService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerService playerService;

    public Player savePlayer(SavePlayerRequestDto savePlayerRequestDto) {
        return playerService.savePlayer(savePlayerRequestDto);
    }

    public Player deletePlayerById(long playerId) {
        return playerService.deletePlayerById(playerId);
    }
}
