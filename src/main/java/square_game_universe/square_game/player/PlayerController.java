package square_game_universe.square_game.player;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping()
    public List<PlayerDTO> getPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PlayerDTO> getPlayerById(@PathVariable("id") Integer id) {
        return playerService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<String> createPlayer(@Valid @RequestBody PlayerDTO player) {
        playerService.save(player);
        return ResponseEntity.ok("Player name is valid. Player created");
//        return Optional.ofNullable(playerService.save(player));
    }

    @DeleteMapping("/{id}")
    public void  deletePlayerById(@PathVariable("id") Integer id) {
        playerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editPlayer(@RequestBody PlayerDTO playerDTO) {
        playerService.edit(playerDTO);
    }

}
