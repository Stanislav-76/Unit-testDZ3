package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.login.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void unloginUser() {
        data.removeIf(user -> user.admin!=true);
    }

}