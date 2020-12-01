package baseball;

import java.util.Scanner;

public class NumberCompare {
    private static int strike = 0;
    private static int ball = 0;
    private static final String nothing = "낫싱";
    private static Scanner input = new Scanner(System.in);

    public void compare(int[] com, int[] user) {
        for (int i=0; i < 3; i++) {
            for (int j=0; j<3; j++) {
                NumberCompare.compareWithcomNum(com[i], user[j], i, j);
            }
        }
    }

    public static void compareWithcomNum(int comNum, int userNum, int i, int j) {
        if (comNum==userNum && i == j) { // 숫자와 자리(인덱스) 모두 같은 경우
            strike++;
        } else if (comNum==userNum && i != j) { // 숫자는 같지만 자리(인덱스)는 다른 경우
            ball++;
        }
    }

    public static void printScore() {
        if (strike==0 && ball==0) {
            System.out.println(nothing);
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            NumberCompare.resetScore(); // 점수 출력 후 새로운 입력을 받으므로 점수 초기화
        }
    }

    public static void resetScore() {
        strike = 0;
        ball = 0;
    }

    public boolean gameClear() {
        if (strike==3) {
            return true;
        }
        return false;
    }
}
