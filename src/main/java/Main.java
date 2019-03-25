import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /* 컴퓨터가 선택할 수 (각 자리 서로 다른 수) */
    static String setComputerNum() {

        StringBuilder sb = new StringBuilder();

        while (true) {

            /* 1 ~ 9 자리의 수 */
            String ran = String.valueOf((int)(Math.random() * 9 + 1));

            /* 추가된 숫자의 자리수까지 반복 */
            for (int i = 0; i < sb.length() + 1; i++) {

                /* 해당 숫자가 존재하지 않으면 추가 */
                if (sb.indexOf(ran) == -1) {
                    sb.append(ran);
                }
            }

            /* 3자리 일경우 반복문 종료 */
            if (sb.length() == 3) break;
        }

        return sb.toString();
    }

    /* 사용자가 입력한 수 */
    static String setUserNum() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("숫자를 입력해주세요 : ");

        return br.readLine();

    }

    /* 컴퓨터 선택 수와 사용자 입력 수 비교하여 결과 출력 */
    static boolean isResult(int[] checkNum) {

        int strike = checkNum[0];
        int ball = checkNum[1];
        boolean isResult = false;

        if (strike != 0) {
            printMessage(strike, "스트라이크 ");
        }

        if (ball != 0) {
            printMessage(ball, "볼");
        }

        printMessage("");

        if (strike == 3) {
            printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isResult = true;
        }

        return isResult;
    }

    /* 볼과 스트라이크를 확인 */
    static int[] checkNum(String computerNum, String userNum) {

        /* 0번째 index 스트라이크, 1번째 index 볼 */
        int[] arr = new int[2];

        for (int i = 0; i < computerNum.length(); i++) {
            for (int j = 0; j < userNum.length(); j++) {
                if (computerNum.charAt(i) == userNum.charAt(j)) {
                    if (i == j) {
                        arr[0] += 1;
                    } else {
                        arr[1] += 1;
                    }
                }
            }
        }

        return arr;
    }

    /* 결과를 출력하는 메소드 */
    static void printMessage(String message) {
        System.out.println(message);
    }

    static void printMessage(int num, String message) {
        System.out.print(num + " " + message);
    }

    /* 게임 시작 여부 */
    static void startGame(String computerNum) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (isResult(checkNum(computerNum, setUserNum()))) {

            String selectGame = br.readLine();

            if (selectGame.equals("1")) {
                /* 게임 재 시작시 컴퓨터가 새로 수를 선택 */
                startGame(setComputerNum());
            } else {
                /* 게임 종료 */
            }

        } else {
            startGame(computerNum);
        }
    }

    /* 메인 메소드 */
    public static void main(String[] args) throws IOException{

        startGame(setComputerNum());

    }
}
