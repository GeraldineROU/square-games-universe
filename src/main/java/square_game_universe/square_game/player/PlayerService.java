package square_game_universe.square_game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerJPARepository playerJPARepository;

//    public List<PlayerDTO> getAll() {
//        return playerDAO.getAll();
//    }

    public PlayerJPAEntity getById(Integer id) {
        return playerJPARepository.getById(id);
    }

//    public Integer create(PlayerDTO playerDTO) {
//        return playerDAO.create(playerDTO);
//    }

//    public List<PlayerDTO> deleteById(int id) {
//        return playerDAO.deleteById(id);
//    }

//    public Optional<PlayerDTO> edit(int id, String name) {
//        return playerDAO.edit(id, name);
//    }

}
