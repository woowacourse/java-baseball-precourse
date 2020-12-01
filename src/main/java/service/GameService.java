package service;

import dto.Result;
import utils.RandomUtils;
import java.util.Scanner;

public class GameService {
    private GameService(){
    }

    public static void start(Scanner scanner) {
        String targetValue = generateTarget();

        while (true) {
            String guessValue = InputService.guess(scanner);
            Result result = compareGuessWithTarget(guessValue, targetValue);
            System.out.println(result);
            if (result.getStrike() == 3) {
                break;
            }
        }

        return;
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

    private static Result compareGuessWithTarget(String guessValue, String targetValue) {
        Result result = new Result();

        for (int i=0; i<guessValue.length(); i++){
            String response = judge(guessValue.charAt(i), i, targetValue);
            if (response.equals("ball")) {
                result.setBall(result.getBall()+1);
            } else if (response.equals("strike")) {
                result.setStrike(result.getStrike()+1);
            }
        }

        return result;
    }

    private static String judge(char charAtIdx, int idx, String targetValue) {
        if (targetValue.charAt(idx) == charAtIdx) {
            return "strike";
        }

        for(int i=0; i<targetValue.length(); i++) {
            if (i == idx) {
                continue;
            }
            if (targetValue.charAt(i) == charAtIdx) {
                return "ball";
            }
        }

        return "";
    }
}
