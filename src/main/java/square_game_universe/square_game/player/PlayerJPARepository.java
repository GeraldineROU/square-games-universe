package square_game_universe.square_game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerJPARepository extends CrudRepository<PlayerJPAEntity, Integer> {


    Optional<PlayerJPAEntity> findById(Integer id);

    List<PlayerJPAEntity> findByName(String name);
}
