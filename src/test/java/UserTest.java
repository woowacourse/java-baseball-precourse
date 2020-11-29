import baseball.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    User user;

    @BeforeEach
    public void user_초기화한다() {
        user = new User();
    }

    @Test
    public void 임의의수3자리_저장된다() {
        String number = "123";
        user.makeNumber(number);

        assertThat(user.getNumber().length()).isEqualTo(3);
        assertThat(user.getNumber()).isEqualTo("123");
    }
}
