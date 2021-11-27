package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private static int ballCount;
    private static int strikeCount;
    private static int X;
    private static int Y;
    private static int Z;
    private static int N;
    private static int x;
    private static int y;
    private static int z;

    public static void main(String[] args) throws IOException {
        //TODO: 숫자 야구 게임 구현

        X = Randoms.pickNumberInRange(1, 9);
        Y = Randoms.pickNumberInRange(1, 9);
        Z = Randoms.pickNumberInRange(1, 9);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (strikeCount != 3) {
            N = Integer.parseInt(bufferedReader.readLine());

            x = N / 100;
            y = (N / 10) % 10;
            z = N % 10;

            ballCount = 0;
            strikeCount = 0;

            input();
            ballCheck();
            strikeCheck();
            print();
        }
    }

    public static void input() {
        if (x == y || y == z || x == z) {
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
        if (X == x) strikeCount++;
        if (Y == y) strikeCount++;
        if (Z == z) strikeCount++;
    }

    public static void ballCheck() {
        if (X == y) ballCount++;
        if (X == z) ballCount++;
        if (Y == x) ballCount++;
        if (Y == z) ballCount++;
        if (Z == x) ballCount++;
        if (Z == y) ballCount++;
    }

    public static void print() {
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 3) {
            System.out.println("3스트라이크" + '\n' + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }
}
