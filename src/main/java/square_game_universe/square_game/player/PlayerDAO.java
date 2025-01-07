package square_game_universe.square_game.player;

import java.util.List;
import java.util.Optional;

public interface PlayerDAO {
    List<PlayerDTORecord> getAll();

    Optional<PlayerDTORecord> getById(int id);

    Integer create(PlayerDTORecord playerDTORecord);

    List<PlayerDTORecord> deleteById(int id);

    Optional<PlayerDTORecord> edit(int id, String name);
}
