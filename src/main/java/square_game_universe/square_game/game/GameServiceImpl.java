package square_game_universe.square_game.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {
    //Contient toutes les méthodes avec logique métier

    Map<String, Game> games = new HashMap<>();

    @Override
    public String createGame(@RequestBody GameCreationParams gameCreationParams) {
        GameFactory gameFactory;
        switch (gameCreationParams.getType()) {
            case "tictactoe":
                gameFactory = new TicTacToeGameFactory();
                break;
            case "taquin":
                gameFactory = new TaquinGameFactory();
                break;
            case "connect4":
                gameFactory = new ConnectFourGameFactory();
                break;
            default:
                return null;
        }

        Game game = gameFactory.createGame(gameCreationParams.getPlayerCount(), gameCreationParams.getBoardSize());
        String uuidString = game.getId().toString();
        games.put(uuidString, game);
        return uuidString;
    }

    @Override
    public String getStatus(String uuid) {
        GameStatus status = games.get(uuid).getStatus();
        return status.toString();
    }
}
