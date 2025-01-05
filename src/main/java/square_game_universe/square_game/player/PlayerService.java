package square_game_universe.square_game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerDAO playerDAO;

    public List<PlayerDTO> getAll() {
        return playerDAO.getAll();
    }

    public Optional<PlayerDTO> getById(int id) {
        return playerDAO.getById(id);
    }

    public PlayerDTO create(String name) {
        return playerDAO.create(name);
    }

    public List<PlayerDTO> deleteById(int id) {
        return playerDAO.deleteById(id);
    }

    public Optional<PlayerDTO> edit(int id, String name) {
        return playerDAO.edit(id, name);
    }

}
