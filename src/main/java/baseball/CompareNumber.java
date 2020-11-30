package baseball;

import java.util.ArrayList;

public class CompareNumber {

    public static boolean compareNumber(ArrayList<Integer> target, ArrayList<Integer> input) {
        int[] score = compareLists(target, input);
        return isEndGame(score);
    }

    static boolean isEndGame(int[] result) {
        boolean endGame = false;

        if (result[0] != 0) {
            System.out.print(result[0] + "볼 ");
        }
        if (result[1] != 0) {
            System.out.print(result[1] + "스트라이크");
        }
        if ((result[0] == 0) && (result[1] == 0)) {
            System.out.print("낫싱");
        }
        System.out.println();

        if (result[1] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            endGame = true;
        }
        return endGame;
    }

    static int[] compareLists(ArrayList<Integer> target, ArrayList<Integer> input) {
        int[] result = new int[2];

        for (int i = 0; i < Application.TARGET_LENGTH; i++) {
            result[0] += howManyContain(target, input.get(i));
        }
        for (int i = 0; i < Application.TARGET_LENGTH; i++) {
            result[1] += howManyStrike(target, input, i);
        }
        result[0] -= result[1];
        return result;
    }

    static int howManyContain(ArrayList<Integer> target, int i) {
        if (Check.isContain(target, i)) {
            return 1;
        }
        return 0;
    }

    static int howManyStrike(ArrayList<Integer> target, ArrayList<Integer> input, int i) {
        if (target.get(i).equals(input.get(i))) {
            return 1;
        }
        return 0;
    }
}
