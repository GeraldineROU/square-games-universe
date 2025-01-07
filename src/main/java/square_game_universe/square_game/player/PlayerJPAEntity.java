package square_game_universe.square_game.player;

import jakarta.persistence.*;

@Entity
public class PlayerJPAEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;

    public PlayerJPAEntity() {}

    public PlayerJPAEntity(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
