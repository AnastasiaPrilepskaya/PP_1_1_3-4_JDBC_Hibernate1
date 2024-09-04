package jm.task.core.jdbc.util;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    // реализуйте настройку соеденения с БД
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
                configuration.setProperty("hibernate.connection.username", "root");
                configuration.setProperty("hibernate.connection.password", "root");
                configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // auto для создания и удаления таблиц
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.setProperty("hibernate.format_sql", "true");
                configuration.addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
                System.out.println("Connected to database");
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

//    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "root";
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
//    public static Connection getConnection() {
//        Connection connection;
//        try {
//            Class.forName(DB_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//            System.out.println("Connected to database");
//            return connection;
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

