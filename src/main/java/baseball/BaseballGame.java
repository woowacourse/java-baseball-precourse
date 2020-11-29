package baseball;

import java.util.LinkedHashSet;

public class BaseballGame {

    // 정답 추측 입력이 올바른지 확인하는 메소드
    static boolean validateGuessInput(String guessStr) {
        // TODO 구현 진행
        return true;
    }

    // guessStr을 int[]로 변환해주는 메소드
    static int[] parseGuessStr(String guessStr) {
        int[] userGuessArr = new int[3];
        // TODO 구현 진행
        return userGuessArr;
    }

    // 스트라이크와 볼을 계산해주는 메소드
    static int checkStrikeAndBall(LinkedHashSet<Integer> answerSet, Integer[] answerArr,
        int[] guessArr) {
        int strikeAndBall = 0;
        // TODO 구현 진행
        return strikeAndBall;
    }
}
