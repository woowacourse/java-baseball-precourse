package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    public static void gameStart(Scanner scanner){
        int targetValue = getRandomValue();
        boolean flag = true;
        do{
            int input = valueInsert(scanner);
            if (checking(targetValue, input)) {
                flag = gameContinue(scanner);
            } else {
                hint(targetValue, input);
            }
        } while(flag);
    }

    private static int getRandomValue() {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        int index = 1;

        do {
            set.add(RandomUtils.nextInt(1, 9));
        } while (set.size() < 3);

        for (Integer s : set) {
            result += s * index;
            index *= 10;
        }

        return result;
    }

    private static void hint(int targetValue, int input) {
        char[] target = String.valueOf(targetValue).toCharArray();
        char[] guess = String.valueOf(input).toCharArray();
        int ball = 0 ;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (target[i] == guess[i]) {
                strike++;
            }

            if (String.valueOf(targetValue).contains(String.valueOf(guess[i]))) {
                ball++;
            }
        }

        ball -= strike;

        resultPrint(ball, strike);
    }

    private static void resultPrint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static boolean gameContinue(Scanner scanner) {
        int input;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = scanner.nextInt();
        if (input == 1) {
            return true;
        } else if (input == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checking(int tartgetValue, int input) {
        return tartgetValue == input;
    }

    private static int valueInsert(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }
}
