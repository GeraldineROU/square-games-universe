package square_game_universe.square_game.player;

import java.util.List;
import java.util.Optional;

public interface PlayerDAO {
    List<PlayerDTO> findAll();

    Optional<PlayerDTO> findById(Integer id);

    PlayerDTO save(PlayerDTO player);

    void deleteById(Integer id);

    void edit(PlayerDTO playerDTO);
}
