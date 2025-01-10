package square_game_universe.square_game.player;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class PlayerJPAEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer age;

    public PlayerJPAEntity() {}

    public PlayerJPAEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
