package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        final int TARGET_LENGTH = 3;
        int[] target = setTarget(TARGET_LENGTH);

        System.out.print(target[0]);
        System.out.print(target[1]);
        System.out.println(target[2]);

    }

    public static int[] setTarget(int targetLength) {
        int[] target = new int[targetLength];
        for (int i = 0; i < 3; i++) {
            target[i] = utils.RandomUtils.nextInt(1, 9);
        }
        return target;
    }
}
