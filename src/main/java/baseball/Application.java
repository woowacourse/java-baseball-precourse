package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }

    public static ArrayList<Integer> createAnswer() {
        final int START_INT = 123;
        final int END_INT = 987;
        ArrayList<Integer> answerNumberList = new ArrayList<>();

        int answer = RandomUtils.nextInt(START_INT, END_INT);
        String answerString = Integer.toString(answer);
        for (int i = 0; i < answerString.length(); i++) {
            answerNumberList.add(Character.getNumericValue(answerString.charAt(i)));
        }
        // TODO 유효성 검사
        return answerNumberList;
    }
}
