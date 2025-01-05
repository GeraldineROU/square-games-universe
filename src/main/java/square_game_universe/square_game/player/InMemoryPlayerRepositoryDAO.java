package square_game_universe.square_game.player;

import java.util.List;
import java.util.Optional;

public interface InMemoryPlayerRepositoryDAO {
    List<PlayerDTO> getAll();

    Optional<PlayerDTO> getById(int id);

    PlayerDTO create(String name);

    List<PlayerDTO> deleteById(int id);

    Optional<PlayerDTO> edit(int id, String name);
}
