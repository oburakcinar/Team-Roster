package com.burak.teamroster.api;

import com.burak.teamroster.entity.Player;
import com.burak.teamroster.service.PlayerService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerService playerService;

    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

}
