package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import org.junit.jupiter.api.Test;
import utils.InputUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeBallsTest {

    @Test
    public void computerMakeBallsTest() {
        Computer.makeBalls();

        assertThat(Computer.balls).isNotEmpty();
    }

    @Test
    public void userMakeBallsTest() {
        User.makeBalls(InputUtils.checkUserBallsInput("123"));

        assertThat(User.balls).isNotEmpty();
    }
}
