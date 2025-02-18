package square_game_universe.square_game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PlayerService implements PlayerDAO {

    @Autowired
    private PlayerMapper mapper;

    @Autowired
    private PlayerJPARepository playerJPARepository;
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public List<PlayerDTO> findAll() {
        List<PlayerJPAEntity> listOfPlayersEntity = playerJPARepository.findAll();
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        listOfPlayersEntity.forEach(player -> {
            PlayerDTO newPlayer = new PlayerDTO(player.getId(), player.getName(), player.getAge());
            playerDTOList.add(newPlayer);
        });
        return playerDTOList;
    }

    @Override
    public Optional<PlayerDTO> findById(Integer id) {
        Optional<PlayerJPAEntity> optionalPlayerEntity = playerJPARepository.findById(id);
        PlayerJPAEntity playerEntity = optionalPlayerEntity.get();
        return Optional.of(new PlayerDTO(playerEntity.getId(), playerEntity.getName(), playerEntity.getAge()));
    }

    @Override
    public PlayerDTO save(PlayerDTO playerDTO) {
        PlayerJPAEntity newPlayerEntity = new PlayerJPAEntity(playerDTO.getName(), playerDTO.getAge());
        playerJPARepository.save(newPlayerEntity);
        PlayerDTO newPlayer = new PlayerDTO(newPlayerEntity.getId(), newPlayerEntity.getName(), newPlayerEntity.getAge());
        return newPlayer;
    }

    @Override
    public void deleteById(Integer id) {
        playerJPARepository.deleteById(id);
    }

    @Override
    public void edit(PlayerDTO playerDTO) {
        Optional<PlayerJPAEntity> optionalPlayerJPAEntity = playerJPARepository.findById(playerDTO.getId());
        PlayerJPAEntity playerEntity = optionalPlayerJPAEntity.get();
        mapper.updatePlayerFromDto(playerDTO, playerEntity);
        playerJPARepository.save(playerEntity);
    }


}
