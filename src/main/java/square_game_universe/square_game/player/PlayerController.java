package square_game_universe.square_game.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping()
    public Collection<PlayerDTO> getPlayers() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PlayerDTO> getPlayerById(@PathVariable("id") int id) {
        return playerService.getById(id);
    }

    @PostMapping()
    public Integer createPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.create(playerDTO);
    }

    @DeleteMapping("/{id}")
    public Collection<PlayerDTO> deletePlayerById(@PathVariable("id") int id) {
        return playerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<PlayerDTO> editPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.edit(playerDTO.id(), playerDTO.name());
    }

}
