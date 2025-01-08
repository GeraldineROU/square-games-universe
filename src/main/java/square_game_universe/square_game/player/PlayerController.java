package square_game_universe.square_game.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerJPARepository playerJPARepository;

    @GetMapping()
    public List<PlayerJPAEntity> getPlayers() {
        return playerJPARepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PlayerJPAEntity> getPlayerById(@PathVariable("id") Integer id) {
        return playerJPARepository.findById(id);
    }

    @PostMapping()
    public PlayerJPAEntity createPlayer(@RequestBody PlayerJPAEntity playerJPAEntity) {
        return playerJPARepository.save(playerJPAEntity);
    }

    @DeleteMapping("/{id}")
    public void  deletePlayerById(@PathVariable("id") Integer id) {
        playerJPARepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editPlayer(@RequestBody PlayerJPAEntity playerJPAEntity) {
        playerJPARepository.save(playerJPAEntity);
    }

}
