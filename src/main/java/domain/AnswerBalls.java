package domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import ui.Output;

public class AnswerBalls {

    private static final int STRIKE_FULL_COUNT = 3;

    private List<Ball> randomBalls = new ArrayList<>();
    private Balls balls;


    public AnswerBalls() {

        this.balls = getRandomBalls();

    }

    //정답 볼인지 판별
    public boolean isCorrectAnswer(List<Ball> inputBalls) {

        int ballCount = balls.countBall(inputBalls);
        int strikeCount = balls.countStrike(inputBalls);

        Output.printStrikeAndBallCount(strikeCount, ballCount);

        if (strikeCount == STRIKE_FULL_COUNT) {
            Output.printGameOver();
            return true;
        }
        return false;

    }

    // 랜덤 공 가져오기
    private Balls getRandomBalls() {

        List<Integer> randomNumbers = new ArrayList<>();
        setRandomNumbers(randomNumbers);
        for (int i = 0; i < randomNumbers.size(); i++) {
            //Ball의 생성자 이용
            randomBalls.add(new Ball(randomNumbers.get(i)));
        }

        return new Balls(randomBalls);

    }

    //랜덤 숫자 3개 생성
    private List<Integer> setRandomNumbers(List<Integer> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        //중복인지 판단
        if (!numbers.contains(randomNumber)) {
            //중복 없으면
            numbers.add(randomNumber);
        }

        //반복문 대신 재귀문 사용해서 원소 추가
        if (numbers.size() != 3) {
            setRandomNumbers(numbers);
        }

        return numbers;
    }


}
