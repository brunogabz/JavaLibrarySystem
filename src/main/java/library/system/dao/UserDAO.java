package library.system.dao;
import library.system.connection.MakeConection;
import library.system.model.User;
import java.sql.*;

public class UserDAO extends BaseDAO {

    public boolean existentEmail(String email) {
        return exists("users", "email", email);
    }

    public void registerUser(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = MakeConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();
            System.out.println("User registered with success!");

        } catch (SQLException e) {
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = MakeConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                    user.setRole(rs.getString("role"));
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error authenticating: " + e.getMessage());
        }
        return null;
    }
}