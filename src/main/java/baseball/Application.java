package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private final static String INPUTORDER = "숫자를 입력하세요 : ";
    private final static String WRONGINPUT = "조건에 맞는 수를 입력해주세요.";
    private final static String RESTARTQUESTION = "게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.";
    private final static String RESTARTGAME = "게임을 재시작합니다.";
    private final static String ENDGAME = "게임을 종료합니다.";
    private final static String ANSWER = "answer :";

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        try {
            startGame();
        } catch (IOException e) {
            e.printStackTrace();   
        }
    }

    public static void startGame() throws IOException {
        int[] inputNumbers = new int[3];
        int ballCount = 0;
        int strikeCount = 0;
        int[] computerNumbers = new int[3];

        makeComputerNumbers(computerNumbers);
        System.out.print(INPUTORDER);

        while (strikeCount != 3) {
            int N = View.input();

            ballCount = 0;
            strikeCount = 0;

            inputNumbers[0] = N / 100;
            inputNumbers[1] = (N / 10) % 10;
            inputNumbers[2] = N % 10;

            inputNumbers(computerNumbers, N);
            ballCount = checkBall(ballCount, computerNumbers, inputNumbers);
            strikeCount = checkStrike(strikeCount, computerNumbers, inputNumbers);
            View.print(ballCount, strikeCount);
        }
    }

    public static void makeComputerNumbers(int[] computerNumbers) {
        while (computerNumbers[0] == computerNumbers[1] || computerNumbers[1] == computerNumbers[2] || computerNumbers[0] == computerNumbers[2]) {
            computerNumbers[0] = Randoms.pickNumberInRange(1, 9);
            computerNumbers[1] = Randoms.pickNumberInRange(1, 9);
            computerNumbers[2] = Randoms.pickNumberInRange(1, 9);
        }
        System.out.println(ANSWER + computerNumbers[0] + computerNumbers[1] + computerNumbers[2]);
    }

    public static void inputNumbers(int[] computerNumbers, int N) {
        if (computerNumbers[0] == computerNumbers[1] || computerNumbers[0] == computerNumbers[2] || computerNumbers[1] == computerNumbers[2]) {
            throw new IllegalArgumentException(WRONGINPUT);
        }

        if (N > 999 || N < 123) {
            throw new IllegalArgumentException(WRONGINPUT);
        }
    }

    public static void restart() throws IOException {
        System.out.println(RESTARTQUESTION);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int reGameQuestion = Integer.parseInt(bufferedReader.readLine());

        if (reGameQuestion == 1) {
            System.out.println(RESTARTGAME);

            try {
                startGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (reGameQuestion == 2) {
            System.out.println(ENDGAME);
        }
    }

    public static int checkStrike(int strikeCount, int[] computerNumbers, int[] inputNumbers) {
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == inputNumbers[i]) strikeCount++;
        }

        return strikeCount;
    }

    public static int checkBall(int ballCount, int[] computerNumbers, int[] inputNumbers) {
        if (computerNumbers[0] == inputNumbers[1]) ballCount++;
        if (computerNumbers[0] == inputNumbers[2]) ballCount++;
        if (computerNumbers[1] == inputNumbers[0]) ballCount++;
        if (computerNumbers[1] == inputNumbers[2]) ballCount++;
        if (computerNumbers[2] == inputNumbers[0]) ballCount++;
        if (computerNumbers[2] == inputNumbers[1]) ballCount++;

        return ballCount;
    }
}