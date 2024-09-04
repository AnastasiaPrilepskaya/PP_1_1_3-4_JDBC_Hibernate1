//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//
//    public UserDaoJDBCImpl() {
//    }
//
//    public void createUsersTable() {
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users (id INT PRIMARY KEY AUTO_INCREMENT," +
//                    " name VARCHAR(30) NOT NULL, lastName VARCHAR(30) NOT NULL, age INT NOT NULL);");
//            System.out.println("Table created");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void dropUsersTable() {
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("DROP TABLE IF EXISTS Users;");
//            System.out.println("Table dropped");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try (Connection connection = Util.getConnection()) {
//            PreparedStatement prepStatement = connection.prepareStatement("INSERT Users (name, lastName, age) VALUES(?, ?, ?)");
//            prepStatement.setString(1, name);
//            prepStatement.setString(2, lastName);
//            prepStatement.setByte(3, age);
//            prepStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (Connection connection = Util.getConnection()) {
//            PreparedStatement prepStatement = connection.prepareStatement("DELETE FROM Users WHERE id = ?");
//            prepStatement.setLong(1, id);
//            prepStatement.executeUpdate();
//            System.out.println("User was removed!");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userArrayList = new ArrayList<>();
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users;");
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                userArrayList.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("List of users is ready!");
//        return userArrayList;
//    }
//
//    public void cleanUsersTable() {
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("DELETE FROM users");
//            System.out.println("Table was cleaned!");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
