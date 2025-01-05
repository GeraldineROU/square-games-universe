package square_game_universe.square_game.player;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryPlayerRepository implements PlayerDAO {
    private List<PlayerDTO> players;

    public InMemoryPlayerRepository() {
        players = new ArrayList<>();
        players.add(new PlayerDTO(0, "Cobalt"));
        players.add(new PlayerDTO(1, "Zéphyr"));
        players.add(new PlayerDTO(2, "Baldr"));
    }

    @Override
    public List<PlayerDTO> getAll() {
        return players;
    }

    @Override
    public Optional<PlayerDTO> getById(int id) {
        return players.stream().filter(playerDTO -> playerDTO.id() == id).findFirst();
    }

    @Override
    public PlayerDTO create(String name) {
        int newId = players.size();

        PlayerDTO newPlayer = new PlayerDTO(newId, name);
        players.add(newPlayer);

        return newPlayer;
    }

    @Override
    public List<PlayerDTO> deleteById(int id) {
        int index = 0;

        while (index < players.size() && index != id) {
            index ++;
        }
        if (index< players.size()) {
            players.remove(index);
        }

        return players;
    }

    @Override
    public Optional<PlayerDTO> edit(int id, String name) {
        int index = 0;

        while (index < players.size() && index != id) {
            index ++;
        }
        if (index< players.size()) {
            players.remove(index);
            PlayerDTO editedPlayer = new PlayerDTO(id, name);
            players.add(editedPlayer);

            return Optional.of(editedPlayer);
        }

        return Optional.empty();
    }
}
