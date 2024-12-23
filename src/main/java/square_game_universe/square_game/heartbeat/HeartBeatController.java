package square_game_universe.square_game.heartbeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {
    @Autowired
    private HeartBeatSensor heartBeatSensor;

    @GetMapping("/heartbeat")
    public int getHeartBeat() {
        return heartBeatSensor.getHeartBeat();
    }


}
