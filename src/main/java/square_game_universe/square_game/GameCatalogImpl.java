package square_game_universe.square_game;

import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGame;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGame;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class GameCatalogImpl implements GameCatalog {

    private TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    private ConnectFourGame connectFourGame = new ConnectFourGame();
    private TaquinGame taquinGame = new TaquinGame(5);

    @Override
    public Collection<String> getGamesIdentifier() {
        Collection<String> gameIdentifier = new ArrayList<String>();
        gameIdentifier.add(ticTacToeGameFactory.getGameFactoryId());
        gameIdentifier.add(connectFourGame.getFactoryId());
        gameIdentifier.add(taquinGame.getFactoryId());
        return gameIdentifier;
    }

}
