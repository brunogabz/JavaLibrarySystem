package library.system.dao;
import java.sql.*;

import library.system.connection.MakeConection;
import library.system.connection.*;

public abstract class BaseDAO {
    protected boolean exists(String table, String column, String value) {

        String sql  = "SELECT COUNT(*) FROM " + table + " WHERE " + column + " = ?";

        try (Connection conn = MakeConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, value);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error on existence verification: " + e.getMessage());
        }
        return false;
    }
}