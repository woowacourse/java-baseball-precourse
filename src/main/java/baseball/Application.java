package baseball;

import java.util.Scanner;
import utils.RandomUtils;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static int guessNum(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요 : ");
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("정수가 아닙니다");
        }

        int input = scanner.nextInt();
        if (input < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다");
        }

        if (input < 100 || 1000 <= input) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다");
        }
        return input;
    }
    public static int[] intToArray(int num) {
        int[] this_array = new int[3];
        for (int i = 2; i > -1; i--) {
            this_array[i] = num % 10;
            num %= 10;
        }
        return this_array;
    }

    public static boolean isValidateRandomNum(int candidate) {
        Set<Integer> store = new HashSet<>();

        int[] candidate_array = intToArray(candidate);
        for (int i : candidate_array) {
            if (store.contains(i)) return false;
            store.add(i);
        }
        return true;
    }

//    public static boolean compareGuessAndAnswer(int num) {
//        int[] guessArray = intToArray(num);
//
//    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 3자리 숫자 생성
        int answer;
        do {
            answer = RandomUtils.nextInt(100, 999);
        } while (isValidateRandomNum(answer));
        System.out.println(answer);

        int number;
        do {
            number = guessNum(scanner);
        } while (number != answer);
        System.out.println("숫자를 맞히셨습니다! 게임 종료");
    }
}
