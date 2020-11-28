package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    final static int TARGET_LENGTH = 3;

    public static void main(String[] args) {
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
                System.out.println(target);
            }

            input = GetInput.inputNumberList(scanner);
            System.out.println(input);
            isEnd = CompareNumber.compareNumber(target, input);

            if (isEnd) {
                restart = Restart.isRestart(scanner);
            }

            if (isEnd && !restart) {
                break;
            }
        }
    }
}
