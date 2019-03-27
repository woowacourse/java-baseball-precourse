package baseball;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameManagerTest {
    GameManager gameManager;

    @Before
    public void setUp() {
        gameManager = GameManager.getInstance();
    }

    @Test
    public void 정답테스트() {

        //given
        List<Integer> resultNumbers = Arrays.asList(3,0);

        //when
        boolean isAnswer = gameManager.judgeResult(resultNumbers);

        //then
        assertThat(isAnswer).isTrue();
    }

    @Test
    public void 오답테스트() {

        //given
        List<Integer> resultNumbers = Arrays.asList(2,1);

        //when
        boolean isAnswer = gameManager.judgeResult(resultNumbers);

        //then
        assertThat(isAnswer).isFalse();
    }
}