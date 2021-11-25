package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayerTest {

    private GamePlayer gamePlayer;

    @BeforeEach
    void setUp(){
        gamePlayer = new GamePlayer();
    }

    @DisplayName("입력값 정상 작동")
    @Test
    void enter_rightInput_True(){
        String input = "123";
        insertSystemInput(input);

        gamePlayer.insertAnswer();
        int[] playerAnswer = gamePlayer.getPlayerAnswer();

        for(int i = 0 ; i < playerAnswer.length; i++){
            Assertions.assertThat(playerAnswer[i]).isGreaterThan(0);
            Assertions.assertThat(playerAnswer[i]).isLessThan(10);
            Assertions.assertThat(playerAnswer[i]).isEqualTo(i+1);
        }

    }

    @DisplayName("중복값 입력 에러 발생")
    @Test
    void enter_duplicateNumber_False(){
        String input = "113";
        insertSystemInput(input);

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.insertAnswer());
    }

    @DisplayName("숫자 아닌값 입력 에러 발생")
    @Test
    void enter_NotNumber_False(){
        String input = "21t";
        insertSystemInput(input);

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.insertAnswer());
    }

    @DisplayName("3자 이상 입력 에러 발생")
    @Test
    void enter_NotRightLength_False(){
        String input = "1534";
        insertSystemInput(input);

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.insertAnswer());
    }

    @DisplayName("0 입력 에러 발생")
    @Test
    void enter_enterZero_False(){
        String input = "120";
        insertSystemInput(input);

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.insertAnswer());
    }

    private void insertSystemInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}