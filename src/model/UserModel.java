package model;

import entity.User;

import java.sql.*;

public class UserModel {
    private static Connection connection = ConnectDatabase.connection;

    public User getUserByNameAndPassword(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idExist = resultSet.getInt("id");
                String usernameExist = resultSet.getString("username");
                String passwordExist = resultSet.getString("password");
                int roleExit = resultSet.getInt("role");
                User user = new User();
                user.setId(idExist);
                user.setUsername(usernameExist);
                user.setPassword(passwordExist);
                user.setRole(roleExit);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
