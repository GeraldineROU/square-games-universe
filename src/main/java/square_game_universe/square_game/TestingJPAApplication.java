package square_game_universe.square_game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import square_game_universe.square_game.player.PlayerJPAEntity;
import square_game_universe.square_game.player.PlayerJPARepository;

import java.util.Optional;

public class TestingJPAApplication {
    private static final Logger log = LoggerFactory.getLogger(SquareGameApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SquareGameApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PlayerJPARepository repository) {
        return args -> {
            repository.save(new PlayerJPAEntity("Plinicha"));
            repository.save(new PlayerJPAEntity("Cobalt"));
            repository.save(new PlayerJPAEntity("Plinicha"));
            repository.save(new PlayerJPAEntity("Zéphyr"));
            repository.save(new PlayerJPAEntity("Plinicha"));
            repository.save(new PlayerJPAEntity("Baldr"));

            log.info("Players found with findAll():");
            log.info("-----------------------------");
            repository.findAll().forEach(playerJPAEntity -> {
                log.info(playerJPAEntity.toString());
            });
            log.info("");

            Optional<PlayerJPAEntity> playerJPAEntity = repository.findById(1);
            log.info("Player found with findById(1):");
            log.info("------------------------------");
            log.info(playerJPAEntity.toString());
            log.info("");

            log.info("Players found with findByName('Plinicha'):");
            log.info("------------------------------------------");
            repository.findByName("Plinicha").forEach(plinicha -> {
                log.info(plinicha.toString());
            });
            log.info("");
        };
    }
}
