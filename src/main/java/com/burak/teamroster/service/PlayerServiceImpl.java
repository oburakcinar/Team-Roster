package com.burak.teamroster.service;

import com.burak.teamroster.converter.PlayerConverter;
import com.burak.teamroster.dto.SavePlayerRequestDto;
import com.burak.teamroster.entity.Player;
import com.burak.teamroster.exception.PlayerBadRequestException;
import com.burak.teamroster.exception.TeamCapacityFullException;
import com.burak.teamroster.repo.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepo;
    private final PlayerConverter playerConverter;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player savePlayer(SavePlayerRequestDto savePlayerRequestDto) {
        //throw team capacity full exception if team size is equals to capacity defined in player service interface
        if(getAllPlayers().size() == TEAM_CAPACITY) {
            throw new TeamCapacityFullException("We were unable to add new player. Team capacity is full!");
        }

        //else save player to db
        Player player = playerConverter.convertPlayerDtoToPlayer(savePlayerRequestDto);
        return playerRepo.save(player);
    }

    @Override
    public Player deletePlayerById(long playerId) {
        Optional<Player> player = playerRepo.findById(playerId);
        //if no player is found by the id, throw exception and show that id field causes the exception
        if(player.isEmpty()) {
            throw new PlayerBadRequestException("We were unable to delete a player with the provided credentials", "id");
        }
        //else delete the player and return deleted player object
        playerRepo.deleteById(playerId);
        return player.get();
    }
}
