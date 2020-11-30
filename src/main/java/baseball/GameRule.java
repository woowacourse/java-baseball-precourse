package baseball;

import java.util.Arrays;
import java.util.List;

/**
 * Baseball 게임 규칙. 정답과 사용자의 입력을 비교하고, strike와 ball을 계산하고, 이를 출력한다.
 * @author 성시형
 * @version 1.0
 */
public class GameRule {
    private int strike;
    private int ball;
    private List<String> answerWords;
    private List<String> userWords;

    /**
     * 정적 팩토리 메소드 생성자. 정답인 랜덤 숫자와 사용자의 입력을 인자로 받아 게임 결과가 담겨있는 GameRule instance로 반환한다.
     * @param answer 정답인 랜덤 숫자
     * @param userInput 사용자의 입력
     * @return 게임결과가 담겨있는 GameRule
     */
    public static GameRule compare(String answer, String userInput) {
        return new GameRule(answer, userInput);
    }

    private GameRule(String answer, String userInput) {
        this.answerWords = Arrays.asList(answer.split(""));
        this.userWords = Arrays.asList(userInput.split(""));
        calculateStrikeAndBall();
    }

    /**
     * 정답과 사용자의 입력이 일치하는지 확인하는 메소드
     * @return 유저의 입력과 정답이 일치하면 true, 다르면 false
     */
    public boolean isCollect() {
        return answerWords.equals(userWords);
    }

    /**
     * 사용자의 입력을 바꾸는 setter 메소드
     * @param userInput 사용자의 새로운 입력
     */
    public void changeUserInput(String userInput) {
        this.userWords = Arrays.asList(userInput.split(""));
        calculateStrikeAndBall();
    }

    /**
     * 결과를 문자열 형태로 리턴하는 메소드.
     * 볼이나 스트라이크가 있다면 n볼 n스트라이크, 둘 다 없다면 낫싱 이란 문자열이 리턴된다.
     * @return 결과가 설명된 문자열
     */
    public String printResult() {
        StringBuilder resultText = new StringBuilder();
        if (ball > 0) {
            resultText.append(String.format("%d볼 ", ball));
        }
        if (strike > 0) {
            resultText.append(String.format("%d스트라이크", strike));
        }
        if (strike == 0 && ball == 0) {
            resultText.append(String.format("낫싱"));
        }

        return resultText.toString();
    }

    private void init() {
        this.strike = 0;
        this.ball = 0;
    }

    private void calculateStrikeAndBall() {
        init();
        for (int i = 0; i < answerWords.size(); i++) {
            String word = answerWords.get(i);
            if (isStrike(i, word)) {
                strike++;
            }
            if (isBall(i, word)) {
                ball++;
            }
        }
    }

    private boolean isStrike(int rightIndex, String word) {
        return userWords.contains(word) && (userWords.indexOf(word) == rightIndex);

    }

    private boolean isBall(int rightIndex, String word) {
        return userWords.contains(word) && (userWords.indexOf(word) != rightIndex);
    }
}
