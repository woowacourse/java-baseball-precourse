package baseball;

import utils.RandomUtils;

import java.util.*;

public class Game {
    public static void gameStart(Scanner scanner){
        int targetValue = getRandomValue();
        boolean flag = true;
        do{
            int input = valueInsert(scanner);
            if (isCorrect(targetValue, input)) {
                flag = gameContinue(scanner);
                targetValue = getRandomValue();
            } else {
                hint(targetValue, input);
            }
        } while(flag);
    }

    private static int getRandomValue() {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        int index = 1;

        do {
            int random = RandomUtils.nextInt(1, 9);
            if (!list.contains(random)) {
                list.add(random);
            }
        } while (list.size() < 3);

        for (Integer s : list) {
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

        hintPrint(ball, strike);
    }

    private static void hintPrint(int ball, int strike) {
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

    private static boolean isCorrect(int tartgetValue, int input) {
        return tartgetValue == input;
    }

    private static int valueInsert(Scanner scanner) {
        int input;
        System.out.print("숫자를 입력해주세요 : ");
        try {
            input = scanner.nextInt();
            isValid(input);
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValid(int input) {
        Set<Character> set = new HashSet<>();
        char[] chars = String.valueOf(input).toCharArray();

        for (char c : chars) {
            set.add(c);
        }

        if (set.size() != 3 || chars.length != 3) {
            throw new IllegalArgumentException();
        }
    }
}
