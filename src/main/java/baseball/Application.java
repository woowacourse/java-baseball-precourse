package baseball;

import java.lang.IllegalArgumentException;
import java.util.Arrays;

public class Application {
    static boolean []check = new boolean[3];
    static int TOTAL = 10;

    public static void main(String[] args) throws IllegalArgumentException {
        while (true) {
            String targetOuput = getRandomNumber();
            boolean end = false;
            while (!end) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = getInput();
                initCheckArray();
                isGameInputRight(userInput);
                int strike = getStrike(targetOuput, userInput);
                int ball = getBall(targetOuput, userInput);
                printResult(strike, ball);
                end = endGame(strike);
            }
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            String regameInput = getInput();
            isRegameInputRight(regameInput);
            if (regameInput.equals("2")) break;
        }
    }

    public static void initCheckArray() {
        Arrays.fill(check, false);
    }

    public static String getRandomNumber() {
        boolean pick = false;
        String random_number = "";
        while (!pick) {
            int [] random_number_cnt = new int[TOTAL];
            boolean can = true;
            random_number = String.valueOf(camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(100, 999));
            for (int index = 0; index < random_number.length(); index++) {
                int now_random_number = random_number.charAt(index) - '0';
                random_number_cnt[now_random_number] += 1;
            }
            if (random_number_cnt[0] > 0) can = false;
            for (int number = 1; number < TOTAL; number++) {
                if (random_number_cnt[number] > 1) can = false;
            }
            if (can) pick = true;
        }
        return random_number;
    }

    public static String getInput() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        return input;
    }

    public static void isGameInputRight(String input) throws IllegalArgumentException {
        int size = input.length();
        boolean is_all_num = true;
        for (int index = 0; index < size; index++) {
            char now_char = input.charAt(index);
            if (!('0' <=  now_char && now_char <= '9')) {
                is_all_num = false;
                break;
            }
        }
        if (size != 3 || !is_all_num) throw new IllegalArgumentException();
    }

    public static void isRegameInputRight(String input) throws IllegalArgumentException {
        int size = input.length();
        boolean is_one_or_two = true;
        for (int index = 0; index < size; index++) {
            char now_char = input.charAt(index);
            if (!('1' <=  now_char && now_char <= '2')) {
                is_one_or_two = false;
                break;
            }
        }
        if (size != 1 || !is_one_or_two) throw new IllegalArgumentException();
    }

    public static int getStrike(String target, String input) {
        int strike = 0;
        for (int index = 0; index < target.length(); index++) {
            char now_target = target.charAt(index);
            char now_input = input.charAt(index);
            if (now_input == now_target) {
                check[index] = true;
                strike += 1;
            }
        }
        return strike;
    }

    public static int getBall(String target, String input) {
        int ball = 0;
        int [] target_number_cnt = new int[TOTAL];
        int [] input_number_cnt = new int[TOTAL];
        for (int index = 0; index < target.length(); index++) {
            if (!check[index]) {
                int now_target_number = target.charAt(index) - '0';
                int now_input_number = input.charAt(index) - '0';
                target_number_cnt[now_target_number] += 1;
                input_number_cnt[now_input_number] += 1;
            }
        }
        for (int number = 1; number < TOTAL; number++) {
            while (target_number_cnt[number] > 0 && input_number_cnt[number] > 0) {
                target_number_cnt[number] -= 1;
                input_number_cnt[number] -= 1;
                ball += 1;
            }
        }
        return ball;
    }

    public static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) System.out.print("낫싱\n");
        else if (strike == 0) System.out.print(ball + "볼\n");
        else if (ball == 0) {
            if (strike == 3) System.out.print(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            else System.out.print(strike + "스트라이크\n");
        }
        else {
            System.out.print(ball + "볼 " + strike + "스트라이크\n");
        }
    }

    public static boolean endGame(int strike) {
        if (strike == 3) return true;
        return false;
    }
}
