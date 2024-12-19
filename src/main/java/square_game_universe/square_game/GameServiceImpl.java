package square_game_universe.square_game;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    //Contient toutes les méthodes avec logique métier

    @Override
    public void createByType (String type) {
        GameFactory gameFactory;
        switch (type) {
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
    }
}
