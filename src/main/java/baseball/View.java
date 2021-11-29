package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static baseball.Application.restart;

public class View {
    public static void print(int ballCount, int strikeCount) throws IOException {
        if (ballCount < 3 && ballCount != 0 && strikeCount == 0) {
            System.out.print(ballCount + "볼" + '\n' + "숫자를 입력하세요 : ");
        }

        if (strikeCount < 3 && strikeCount != 0 && ballCount == 0) {
            System.out.print(strikeCount + "스트라이크" + '\n' + "숫자를 입력하세요 : ");
        }

        if (strikeCount == 3) {
            System.out.println("3스트라이크" + '\n' + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart();
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(ballCount + "볼" + " " + strikeCount + "스트라이크" + '\n' + "숫자를 입력하세요 : ");
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱" + '\n' + "숫자를 입력하세요 : ");
        }
    }

    public static int input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        return N;
    }
}
