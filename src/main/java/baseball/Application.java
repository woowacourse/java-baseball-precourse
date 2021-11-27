package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private static int ballCount;
    private static int strikeCount;
    private static final int[] computerNumbers = new int[3];
    private static int N;
    private static final int[] inputNumbers = new int[3];

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        try {
            startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void startGame() throws IOException {
        makeRandomNum();
        System.out.println("숫자를 입력하세요.");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (strikeCount != 3) {
            N = Integer.parseInt(bufferedReader.readLine());

            inputNumbers[0] = N / 100;
            inputNumbers[1] = (N / 10) % 10;
            inputNumbers[2] = N % 10;

            ballCount = 0;
            strikeCount = 0;

            input();
            ballCheck();
            strikeCheck();
            print();
        }
    }

    public static void makeRandomNum() {
        for (int i = 0; i < 3; i++) {
            computerNumbers[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    public static void input() {
        if (computerNumbers[0] == computerNumbers[1] || computerNumbers[0] == computerNumbers[2] || computerNumbers[1] == computerNumbers[2]) {
            throw new IllegalArgumentException("조건에 맞는 수를 입력해주세요.");
        }

        if (N > 999 || N < 123) {
            throw new IllegalArgumentException("조건에 맞는 수를 입력해주세요.");
        }
    }

    public static void restart() throws IOException {
        if (strikeCount == 3) {
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int reGameQuestion = Integer.parseInt(bufferedReader.readLine());

            if (reGameQuestion == 1) {
                System.out.println("게임을 재시작합니다.");

            }

            if (reGameQuestion == 2) {
                System.out.println("게임을 종료합니다.");
            }
        }
    }

    public static void strikeCheck() {
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == inputNumbers[i]) strikeCount++;
         }
    }

    public static void ballCheck() {
        if (computerNumbers[0] == inputNumbers[1]) ballCount++;
        if (computerNumbers[0] == inputNumbers[2]) ballCount++;
        if (computerNumbers[1] == inputNumbers[0]) ballCount++;
        if (computerNumbers[1] == inputNumbers[2]) ballCount++;
        if (computerNumbers[2] == inputNumbers[0]) ballCount++;
        if (computerNumbers[2] == inputNumbers[1]) ballCount++;
    }

    public static void print() throws IOException {
        if (ballCount < 3 && ballCount !=0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount < 3 && strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 3) {
            System.out.println("3스트라이크" + '\n' + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart();
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }
}
