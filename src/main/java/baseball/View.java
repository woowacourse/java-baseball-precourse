package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static baseball.Application.restart;

public class View {
    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";
    private final static String INPUTNUMBER = "숫자를 입력하세요 : ";
    private final static String THREESTRIKE = "3스트라이크";
    private final static String CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String BLANK = " ";
    private final static String NOTHING = "낫싱";
    private final static char LINEBREAK = '\n';

    public static void print(int ballCount, int strikeCount) throws IOException {
        if (ballCount < 3 && ballCount != 0 && strikeCount == 0) {
            System.out.print(ballCount + BALL + LINEBREAK + INPUTNUMBER);
        }

        if (strikeCount < 3 && strikeCount != 0 && ballCount == 0) {
            System.out.print(strikeCount + STRIKE + LINEBREAK + INPUTNUMBER);
        }

        if (strikeCount == 3) {
            System.out.println(THREESTRIKE + LINEBREAK + CORRECT);
            restart();
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(ballCount + BALL + BLANK + strikeCount + STRIKE + LINEBREAK + INPUTNUMBER);
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING + LINEBREAK + INPUTNUMBER);
        }
    }

    public static int input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        return N;
    }
}
