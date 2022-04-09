package com.burak.teamroster.service;

import com.burak.teamroster.dto.SavePlayerRequestDto;
import com.burak.teamroster.entity.Player;

import java.util.List;

public interface PlayerService {

    int TEAM_CAPACITY = 12;

    public List<Player> getAllPlayers();
    public Player savePlayer(SavePlayerRequestDto savePlayerRequestDto);
    public Player deletePlayerById(long playerId);

}
