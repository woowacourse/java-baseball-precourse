/*
 * 클래스 이름 : OutputUtilOutputUtil
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

package utils;

public class OutputUtil {

    public void printRequireUserScoreBoard() {
        System.out.print("숫자를 입력해주세요 :");
    }

    public void printRelayQuestion() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printScore(Integer strike, Integer ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
            return;
        }

        if (ball == 0) {
            System.out.println(strike + " 스트라이크");
            return;
        }

        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }

        if (strike > 0 && strike < 3 && ball > 0 && ball < 3) {
            System.out.println(strike + " 스트라이크 " + ball + "볼");
            return;
        }
    }
}
