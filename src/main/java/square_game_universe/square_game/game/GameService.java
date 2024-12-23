package square_game_universe.square_game.game;

public interface GameService {


    String createGame(GameCreationParams gameCreationParams);

    String getStatus(String uuid);
}
