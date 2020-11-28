package baseball;

import java.util.LinkedHashSet;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    // 세 개의 숫자로 이루어진 Set을 생성하는 메소드
    static LinkedHashSet<Integer> generateAnswer() {
        LinkedHashSet<Integer> numSet = new LinkedHashSet<Integer>();
        // TODO 구현 진행
        return numSet;
    }

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

    // guessResult의 값에 알맞는 스트라이크/볼 갯수를 출력해주는 메소드
    static void printGuessResult(int guessResult) {
        // TODO 구현 진행
    }

    // 숫자 야구 게임을 진행하는 메소드
    static void playBaseballGame(Scanner scanner) {
        // TODO 구현 진행
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
