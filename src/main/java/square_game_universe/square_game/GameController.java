package square_game_universe.square_game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {

        return UUID.randomUUID().toString();
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {

        return null;
    }

}
