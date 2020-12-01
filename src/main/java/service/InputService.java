package service;

import java.util.Scanner;

public class InputService {
    public static String guess(Scanner scanner) {
        String input;

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                input = scanner.nextLine();

                checkInputValidity(input);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Unexpected Exception: " + e);
            }
        }

        return input;
    }

    private static void checkInputValidity(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 맞지 않습니다.(요구: 1에서 9까지의 수로 이루어진 3자리의 수)");
        }

        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException("유효하지 않은 입력값입니다.(요구: 1에서 9까지의 수로 이루어진 3자리의 수)");
            }
        }
    }
}