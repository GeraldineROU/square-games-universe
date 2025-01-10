package square_game_universe.square_game.player;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlayerDTO {

    private Integer id;

    @NotNull
    @Size(min=4, max=20)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    public PlayerDTO(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public @NotNull @Min(18) Integer getAge() {
        return age;
    }

    public void setAge(@NotNull @Min(18) Integer age) {
        this.age = age;
    }

    public @NotNull @Size(min = 4, max = 20) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 4, max = 20) String name) {
        this.name = name;
    }

    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
