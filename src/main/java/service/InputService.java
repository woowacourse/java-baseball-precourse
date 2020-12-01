package service;

import java.util.Scanner;

public class InputService {
    public static String guess(Scanner scanner) {
        String input;

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                input = scanner.nextLine();

                checkGuessInputValidity(input);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Unexpected Exception: " + e);
            }
        }

        return input;
    }

    private static void checkGuessInputValidity(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 맞지 않습니다.(Required: 1에서 9까지의 수로 이루어진 3자리의 수)");
        }

        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException("유효하지 않은 입력값입니다.(Required: 1에서 9까지의 수로 이루어진 3자리의 수)");
            }
        }
    }

    public static boolean resume(Scanner scanner) {
        String input;

        while (true) {
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = scanner.nextLine();

                checkResumeInputValidity(input);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Unexpected Exception: " + e);
            }
        }

        return input.equals("1");
    }

    private static void checkResumeInputValidity(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.(Required: 1(재시작) 또는 2(종료))");
        }
    }
}