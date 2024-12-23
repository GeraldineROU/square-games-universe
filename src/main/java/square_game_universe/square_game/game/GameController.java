package square_game_universe.square_game.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    //contient seulement la logique liée aux requetes

    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams gameCreationParams) throws BadRequestException {


        String game = null;
        try {
            game = gameService.createGame(gameCreationParams);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(e);
        }

        return game;
    }

    @GetMapping("/games/{gameId}")
    public String getGameStatus(@PathVariable("gameId") String gameId) {
        return gameService.getStatus(gameId);
    }


}
