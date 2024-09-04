package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        List<User> users = new ArrayList<>();
        users.add(new User("Nastya", "Prilepskaya", (byte) 25));
        users.add(new User("Ivan", "Ivanov", (byte) 21));
        users.add(new User("Lollipop", "Popovich", (byte) 18));
        users.add(new User("Katya", "Kotova", (byte) 26));

        for (User user : users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        }

        List<User> usersTable = userService.getAllUsers();
        for (User user : usersTable) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
