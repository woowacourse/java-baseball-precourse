package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    public static int guessNum (Scanner scanner) {
        System.out.print("숫자를 입력해 주세요: ");
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

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 3자리 숫자 생성
        StringBuilder randomNum = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            randomNum.append(RandomUtils.nextInt(1, 9));
        }
        int answer = Integer.parseInt(randomNum.toString());
        System.out.println(answer);

        int number;
        do {
            number = guessNum(scanner);
        } while (number != answer);
        System.out.println("숫자를 맞히셨습니다! 게임 종료");
    }
}
