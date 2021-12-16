package customers;

import java.util.HashMap;

/*
 * Класс создан для имитации получения данных о пользователе из БД.
 * */
public class UserData {
    private static HashMap<Integer, User> users = new HashMap();

    public UserData() {
        if (users.isEmpty()) {
            users.put(1, new User("Aidar", 21));
            users.put(2, new User("Damir", 21));
            users.put(3, new User("Dima", 23));
            users.put(4, new User("Alex", 27));
            users.put(5, new User("Polina", 21));
            users.put(6, new User("Aleksandr", 36));
            users.put(7, new User("Max", 24));
            users.put(8, new User("Kirill", 24));
        }
    }

    /*
     * Метод, реализующий получение информации о пользователе по id.
     * @id - идентификатор пользователя.
     * */
    public User getUser(int id) {
        return users.get(id);
    }
}

