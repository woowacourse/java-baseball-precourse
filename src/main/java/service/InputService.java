package service;

import java.util.Scanner;

public class InputService {
    public static String guess(Scanner scanner) {
        String input;

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                input = scanner.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Unexpected Exception: " + e);
            }
        }

        return input;
    }
}