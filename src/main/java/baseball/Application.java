package baseball;

import java.util.Scanner;

public class Application {
    final static int TARGET_LENGTH = 3;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        int[] target = setTarget();
        int[] inputNumber = new int[TARGET_LENGTH];

        try {
            inputNumber = getInputNumber(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("오류 : 0을 제외한 3자리 숫자만 입력 가능!");
        }

        System.out.println(inputNumber[2]);


    }

    public static int[] setTarget() {
        int[] target = new int[TARGET_LENGTH];
        for (int i = 0; i < 3; i++) {
            target[i] = utils.RandomUtils.nextInt(1, 9);
        }
        return target;
    }

    public static int[] getInputNumber(Scanner scanner) throws IllegalArgumentException {
        int[] inputNumber = new int[TARGET_LENGTH];
        System.out.println("숫자를 입력하세요: ");
        String input = scanner.next();

        if (input.length() != TARGET_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < TARGET_LENGTH; i++) {
            String temp = input.substring(i, i + 1);
            inputNumber[i] = Integer.parseInt(temp);
            if (inputNumber[i] == 0) {
                throw new IllegalArgumentException();
            }
        }

        return inputNumber;
    }
}
