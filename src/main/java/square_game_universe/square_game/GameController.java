package square_game_universe.square_game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {
    //contient seulement la logique liée aux requetes

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {
        GameFactory gameFactory;

        //logique de vérif à implémenter côté service:
        switch (params.getType()) {
            case "tictactoe":
                gameFactory = new TicTacToeGameFactory();
                break;
            case "connect4":
                gameFactory = new ConnectFourGameFactory();
                break;
            case "taquin":
                gameFactory = new TaquinGameFactory();
                break;
            default:
                return "";
        }

        Game game = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());

        return game.getId().toString();
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {

        return null;
    }

    //fonction pour effacer une partie

    //

}
