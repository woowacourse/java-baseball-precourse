/*
 * 클래스 이름: BaseballGame
 *
 * 날짜: 2019년 3월 25일
 */

import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean reGame;

        do {
            doGame();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int answer = scan.nextInt();

            if (answer == 1) {
                reGame = true;
            } else {
                reGame = false;
            }
        } while (reGame);

        scan.close();
    }

    /*
     * 1부터 9까지 서로 다른 숫자로 이루어진 3자리의 수를 만들어 배열로 리턴한다.
     */
    int[] makeComNum() {
        int[] comNum = new int[3];
        int[] checkOverlap = new int[10];

        for (int i = 0; i < 3; i++) {
            comNum[i] = (int) (Math.random() * 9) + 1;

            if (checkOverlap[comNum[i]] == 0) {
                checkOverlap[comNum[i]]++;
            } else {
                i--;
                continue;
            }
        }
        return comNum;
    }

    /*
     * 사용자의 입력을 받아 배열로 리턴한다.
     */
    int[] makeUserNum(int userInput) {
        int[] userNum = new int[3];

        for (int i = 2; i >= 0; i--) {
            userNum[i] = userInput % 10;
            userInput /= 10;
        }

        return userNum;
    }

    /*
     * 컴퓨터의 숫자 배열, 사용자의 숫자 배열을 받아 스트라이크와 볼을 계산한다.
     * result[0]은 스트라이크, result[1]은 볼을 의미.
     */
    int[] countResult(int[] comNum, int[] userNum) {
        int[] result = new int[2];
        int[] num = new int[10];

        for (int i = 0; i < 3; i++) {
            num[comNum[i]]++;
        }

        for (int i = 0; i < 3; i++) {
            if (comNum[i] == userNum[i]) {
                result[0]++;
            } else if (num[userNum[i]] != 0) {
                result[1]++;
            }
        }

        return result;
    }

    /*
     * 결과를 출력한다.
     * 3 스트라이크면 false, 아니면 true를 리턴한다.
     */
    boolean printResult(int[] result) {
        boolean isWrong = true;

        if (result[0] == 3) {
            System.out.println("3 스트라이크");
            isWrong = false;
        } else if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[0] + " 스트라이크 " + result[1] + " 볼");
        } else if (result[0] > 0) {
            System.out.println(result[0] + " 스트라이크");
        } else if (result[1] > 0) {
            System.out.println(result[1] + " 볼");
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }

        return isWrong;
    }

    /*
     * 게임을 진행한다.
     * 3 스트라이크면 printResult()에서 false를 리턴받아 do-while문을 끝낸다.
     */
    static void doGame() {
        BaseballGame game = new BaseballGame();
        Scanner scan = new Scanner(System.in);
        int[] comNum = game.makeComNum();
        boolean isWrong = true;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            int userInput = scan.nextInt();
            int[] userNum = game.makeUserNum(userInput);
            int[] result = game.countResult(comNum, userNum);
            isWrong = game.printResult(result);
        } while (isWrong);
    }
}