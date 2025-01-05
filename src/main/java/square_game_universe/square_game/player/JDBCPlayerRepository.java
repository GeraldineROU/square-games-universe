package square_game_universe.square_game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import square_game_universe.square_game.common.DatabaseConnectionHelper;
import square_game_universe.square_game.common.DatabaseConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("!In_memory")
public class JDBCPlayerRepository implements PlayerDAO{

    @Autowired
    private DatabaseConnectionHelper databaseConnectionHelper;

    private ResultSet executeQuery(String sql) throws SQLException {
        Connection conn = databaseConnectionHelper.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        return ps.executeQuery();
    }

    private ResultSet executeUpdate(String sql, PlayerDTO playerDTO) throws SQLException {
        Connection conn = DatabaseConnectionSingleton.INSTANCE.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, playerDTO.name());
        int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            return null;
        }

        return ps.getGeneratedKeys();
    }

    @Override
    public List<PlayerDTO> getAll() {
        List<PlayerDTO> players = new ArrayList<>();


        try (ResultSet rs = executeQuery("SELECT * FROM players")) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");

                players.add(new PlayerDTO(id, name));
            }
        }  catch (SQLException e) {
            throw new RuntimeException("Database error", e);
        }

        return players;
            }

    @Override
    public Optional<PlayerDTO> getById(int id) {
        Connection conn = databaseConnectionHelper.getConnection();

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM players where ID=?")) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idFromDatabase = rs.getInt("ID");
                String name = rs.getString("NAME");

                return Optional.of(new PlayerDTO(idFromDatabase, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve player", e);
        }

        return Optional.empty();
    }

    @Override
    public Integer create(PlayerDTO playerDTO) {
        String insertInto = "INSERT INTO players (name) values ( ? )";

        try (ResultSet generatedKeys = executeUpdate(insertInto, playerDTO)) {
            if (generatedKeys == null) {
                return null;
            }

            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }

        return null;
    }

    @Override
    public List<PlayerDTO> deleteById(int id) {
        return List.of();
    }

    @Override
    public Optional<PlayerDTO> edit(int id, String name) {
        return Optional.empty();
    }
}
