package utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputUtils {
    public static void checkUserInput(Scanner scanner) {
        isNumber(scanner);
        isRightLength(scanner);
        isWithoutDuplicate(scanner);
    }

    private static void isNumber(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isRightLength(Scanner scanner) {
        if (scanner.nextLine().length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void isWithoutDuplicate(Scanner scanner) {
        Set<Integer> numberSet = new HashSet<Integer>();
        String[] strList = scanner.nextLine().split("");

        for (int i = 0; i < strList.length; i++) {
            int number = Integer.parseInt(strList[i]);
            if (number == 0 || numberSet.contains(number)) {
                throw new IllegalArgumentException();
            }
            numberSet.add(number);
        }
    }
}
