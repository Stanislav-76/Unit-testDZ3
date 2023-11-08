package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.hw.MainHW;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {
    User user;
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        user = new User("admin", "admin");
        user.authenticate("admin", "admin");
    }

    @Test
    void testAddUser() {
        int count = userRepository.data.size();
        userRepository.addUser(user);
        assertThat(userRepository.data.size()).isEqualTo(count+1);
    }

    @Test
    void testAddUserFalse() {
        int count = userRepository.data.size();
        userRepository.addUser(new User("admin", "admin"));
        assertThat(userRepository.data.size()).isEqualTo(count);
    }

    @Test
    void testFindByName() {
        userRepository.addUser(user);
        assertTrue(userRepository.findByName("admin"));
        assertFalse(userRepository.findByName("semen"));
    }

    @Test
    void testUnloginUser() {
        user.admin = true;
        userRepository.addUser(user);
        User user1 = new User("admin", "adm");
        User user2 = new User("vasja", "111");
        user1.isAuthenticate = true;
        user2.isAuthenticate = true;
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        int count = userRepository.data.size();
        userRepository.unloginUser();

        assertThat(userRepository.data.size()).isEqualTo(1);
        assertThat(userRepository.data.size()).isEqualTo(count-2);
    }
}
