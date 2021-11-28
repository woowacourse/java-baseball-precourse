package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import baseball.vo.Point;

class BaseBallGameTest {

    //사용자 입력 예외 처리 확인
    @Test
    public void 사용자_입력(){
        BaseBallGame baseBallGame = new BaseBallGame();

        try{
            String input = "123";
            baseBallGame.validate(input);
        }
        catch (IllegalArgumentException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    //정답과 사용자의 입력 비교 값 확인
    @Test
    public void 정답_입력_비교(){
        BaseBallGame baseBallGame = new BaseBallGame();

        ArrayList<String> randomNumber1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Point point1 = baseBallGame.compare(randomNumber1, "123");
        assertEquals(point1.getStrike(), 3);

        ArrayList<String> randomNumber2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Point point2 = baseBallGame.compare(randomNumber2, "321");
        assertEquals(point2.getStrike(), 1);
        assertEquals(point2.getBall(), 2);
    }
}