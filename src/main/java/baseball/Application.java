package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    final static int TARGET_LENGTH = 3;

    public static void main(String args[]) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        ArrayList<Integer> target = new ArrayList<Integer>();
        ArrayList<Integer> input = new ArrayList<Integer>();
        boolean restart = true;
        boolean isEnd = false;

        while (true) {
            if (restart) {
                target = SetTarget.setTargetList();
                restart = false;
            }

            isEnd = catchExceptionOfGetInput(scanner, target);

            if (isEnd) {
                restart = catchExceptionOfRestart(scanner);
            }
            if (isEnd && !restart) {
                break;
            }
        }
    }

    static boolean catchExceptionOfGetInput(Scanner scanner, ArrayList<Integer> target) {
        boolean result = false;
        try {
            ArrayList<Integer> input = GetInput.inputNumberList(scanner);
            result = CompareNumber.compareNumber(target, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    static boolean catchExceptionOfRestart(Scanner scanner) {
        while (true) {
            try {
                return Restart.isRestart(scanner);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
