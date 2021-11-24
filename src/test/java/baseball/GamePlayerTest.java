package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayerTest {

    @DisplayName("정상 작동")
    @Test
    void enter_rightInput(){
        String input = "123";
        enterSystemInput(input);

        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.writeAnswer();
        int[] playerAnswer = gamePlayer.getPlayerAnswer();

        for(int i = 0 ; i < playerAnswer.length; i++){
            Assertions.assertThat(playerAnswer[i]).isGreaterThan(0);
            Assertions.assertThat(playerAnswer[i]).isLessThan(10);
            Assertions.assertThat(playerAnswer[i]).isEqualTo(i+1);
        }

    }

    @DisplayName("중복값 입력 에러 발생")
    @Test
    void enter_duplicateNumber(){
        String input = "113";
        enterSystemInput(input);

        GamePlayer gamePlayer = new GamePlayer();

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.writeAnswer());
    }

    @DisplayName("숫자 아닌값 입력 에러 발생")
    @Test
    void enter_NotNumber(){
        String input = "21t";
        enterSystemInput(input);

        GamePlayer gamePlayer = new GamePlayer();

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.writeAnswer());
    }

    @DisplayName("3자 이상 입력 에러 발생")
    @Test
    void enter_NotRightLength(){
        String input = "1534";
        enterSystemInput(input);

        GamePlayer gamePlayer = new GamePlayer();

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.writeAnswer());
    }

    @DisplayName("0 입력 에러 발생")
    @Test
    void enter_enterZero(){
        String input = "120";
        enterSystemInput(input);

        GamePlayer gamePlayer = new GamePlayer();

        assertThrows(IllegalArgumentException.class, () -> gamePlayer.writeAnswer());
    }

    private void enterSystemInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}