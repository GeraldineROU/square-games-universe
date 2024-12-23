package square_game_universe.square_game.heartbeat;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartBeat implements HeartBeatSensor {
    @Override
    public int getHeartBeat() {
        return (int) ((Math.random()*(220 - 40)) + 40);
    }
}
