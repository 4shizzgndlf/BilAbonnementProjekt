package dk.ek.bilabonnementprojekt.repositories;

import dk.ek.bilabonnementprojekt.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM brugere";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("role"),
                        rs.getString("created_at")
                );
                users.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
