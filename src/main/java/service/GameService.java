package service;

import utils.RandomUtils;

import java.util.Scanner;

public class GameService {
    private GameService(){
    }

    public static void start(Scanner scanner) {
    }

    private static String generateTarget() {
        String target;

        while (true) {
            target = Integer.toString(RandomUtils.nextInt(100, 999));
            break;
        }

        return target;
    }
}
