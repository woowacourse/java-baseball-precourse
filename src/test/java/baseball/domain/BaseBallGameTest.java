package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.vo.Point;
import baseball.view.OutputView;

class BaseBallGameTest {

    //사용자 입력 예외 처리 확인
    @Test
    public void 사용자_입력() {
        BaseBallGame baseBallGame = new BaseBallGame();

        try {
            String input = "123";
            baseBallGame.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    //정답과 사용자의 입력 비교 값 확인
    @Test
    public void 정답_입력_비교() {
        BaseBallGame baseBallGame = new BaseBallGame();

        ArrayList<String> randomNumber1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Point point1 = baseBallGame.compare(randomNumber1, "123");
        assertEquals(point1.getStrike(), 3);

        ArrayList<String> randomNumber2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Point point2 = baseBallGame.compare(randomNumber2, "321");
        assertEquals(point2.getStrike(), 1);
        assertEquals(point2.getBall(), 2);
    }

    //결과 값 확인
    @Test
    public void 게임_결과_출력() {
        BaseBallGame baseBallGame = new BaseBallGame();

        //정답이 홀수인 경우 낫싱 출력
        ArrayList<String> randomNumber1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Point point1 = baseBallGame.compare(randomNumber1, "967");
        OutputView outputView1= new OutputView(point1.getStrike(), point1.getBall(), randomNumber1);
        assertEquals(outputView1.display(), "낫싱");

        //정답이 짝수인 경우 포볼 출력
        ArrayList<String> randomNumber2 = new ArrayList<>(Arrays.asList("1", "2", "4"));
        Point point2 = baseBallGame.compare(randomNumber2, "967");
        OutputView outputView2 = new OutputView(point2.getStrike(), point2.getBall(), randomNumber2);
        assertEquals(outputView2.display(), "포볼");

        ArrayList<String> randomNumber3 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Point point3 = baseBallGame.compare(randomNumber3, "132");
        OutputView outputView3 = new OutputView(point3.getStrike(), point3.getBall(), randomNumber3);
        assertEquals(outputView3.display(), "2볼 1스트라이크");
    }
}