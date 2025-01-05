package square_game_universe.square_game.player;

import java.util.List;
import java.util.Optional;

public interface PlayerDAO {
    List<PlayerDTO> getAll();

    Optional<PlayerDTO> getById(int id);

    Integer create(PlayerDTO playerDTO);

    List<PlayerDTO> deleteById(int id);

    Optional<PlayerDTO> edit(int id, String name);
}
