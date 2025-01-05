package square_game_universe.square_game.common;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnectionHelper {
    private final Connection conn;

    public DatabaseConnectionHelper() {
        String connectionUrl = "jdbc:mysql://localhost:3306/square_games_db";
        try {
            conn = DriverManager.getConnection(connectionUrl, "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
