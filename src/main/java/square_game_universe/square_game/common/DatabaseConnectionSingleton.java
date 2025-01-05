package square_game_universe.square_game.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseConnectionSingleton {
    INSTANCE;

    private final Connection conn;

    DatabaseConnectionSingleton() {
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
