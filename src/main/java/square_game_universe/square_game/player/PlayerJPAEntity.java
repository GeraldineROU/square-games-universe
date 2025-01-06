package square_game_universe.square_game.player;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    protected PlayerJPAEntity() {}

    public PlayerJPAEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Player[id=%d, name='%s']", id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
