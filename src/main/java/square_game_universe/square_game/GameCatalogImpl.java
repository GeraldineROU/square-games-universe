package square_game_universe.square_game;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class GameCatalogImpl implements GameCatalog {

    private TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();

    @Override
    public Collection<String> getGameIdentifier() {
        Collection<String> gameIdentifier = new ArrayList<String>();
        gameIdentifier.add(ticTacToeGameFactory.getGameFactoryId());
        return gameIdentifier;
    }

}
