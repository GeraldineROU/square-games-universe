package square_game_universe.square_game.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private InMemoryPlayerRepository inMemoryPlayerRepository;

    @GetMapping()
    public Collection<PlayerDTO> getPlayers() {
        return inMemoryPlayerRepository.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PlayerDTO> getPlayerById(@PathVariable("id") int id) {
        return inMemoryPlayerRepository.getById(id);
    }

    @PostMapping()
    public PlayerDTO createPlayer(@RequestBody PlayerDTO playerDTO) {
        return inMemoryPlayerRepository.create(playerDTO.name());
    }

    @DeleteMapping("/{id}")
    public Collection<PlayerDTO> deletePlayerById(@PathVariable("id") int id) {
        return inMemoryPlayerRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<PlayerDTO> editPlayer(@RequestBody PlayerDTO playerDTO) {
        return inMemoryPlayerRepository.edit(playerDTO.id(), playerDTO.name());
    }

}
