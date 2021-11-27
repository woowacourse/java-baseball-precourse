package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private static int ballCount;
    private static int strikeCount;

    public static void main(String[] args) throws IOException {
        //TODO: 숫자 야구 게임 구현

        int X = Randoms.pickNumberInRange(1, 9);
        int Y = Randoms.pickNumberInRange(1, 9);
        int Z = Randoms.pickNumberInRange(1, 9);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void print() {
        if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 3) {
            System.out.println("3스트라이크" + '\n' + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }
}
