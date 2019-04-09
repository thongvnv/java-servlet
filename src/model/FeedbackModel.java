package model;

import entity.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackModel {
    private static Connection connection = ConnectDatabase.connection;

    /*
    * Feedback staus:
    * -1: xóa
    * 0: đợi duyệt
    * 1: đã duyệt
     */

    public boolean insert(Feedback feedback) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO feedbacks(user_id, title, content) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, feedback.getUserId());
            preparedStatement.setString(2, feedback.getTitle());
            preparedStatement.setString(3, feedback.getContent());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE feedbacks SET status = 1 WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Feedback> getListFeedback() {
        ArrayList<Feedback> listFeedback = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM feedbacks WHERE status = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Feedback feedback = new Feedback();
                feedback.setId(id);
                feedback.setUserId(userId);
                feedback.setTitle(title);
                feedback.setContent(content);
                listFeedback.add(feedback);
            }
            return listFeedback;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Feedback> getAllFeedback() {
        ArrayList<Feedback> listFeedback = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM feedbacks");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                int status = resultSet.getInt("status");
                Feedback feedback = new Feedback();
                feedback.setId(id);
                feedback.setUserId(userId);
                feedback.setTitle(title);
                feedback.setContent(content);
                feedback.setStatus(status);
                listFeedback.add(feedback);
            }
            return listFeedback;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
