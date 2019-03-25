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

    int[] makeUserNum(int userInput) {
        int[] userNum = new int[3];

        for (int i = 2; i >= 0; i--) {
            userNum[i] = userInput % 10;
            userInput /= 10;
        }

        return userNum;
    }

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