package service;

import utils.RandomUtils;

import java.util.Scanner;

public class GameService {
    private GameService(){
    }

    public static void start(Scanner scanner) {
        String target = generateTarget();
    }

    private static String generateTarget() {
        String target;

        do {
            target = Integer.toString(RandomUtils.nextInt(100, 999));
            System.out.println(target);
        } while (!checkTargetValidity(target));

        return target;
    }

    private static boolean checkTargetValidity(String target) {
        if (target.charAt(0) == target.charAt(1)
                || target.charAt(1) == target.charAt(2)
                || target.charAt(0) == target.charAt(2)) {
            return false;
        }

        if (target.charAt(0) == '0'
                || target.charAt(1) == '0'
                || target.charAt(2) == '0') {
            return false;
        }

        return true;
    }
}
