package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int START_BOUND = 1;
    private static final int END_BOUND = 9;

    private static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        generateAnswers();
    }

    private static void generateAnswers() {
        while (answers.size() < 3)
            generateOneAnswer();
    }

    private static void generateOneAnswer() {
        int newAnswer = RandomUtils.nextInt(START_BOUND, END_BOUND);
        if (isUniqueAnswer(newAnswer))
            answers.add(newAnswer);
    }

    private static boolean isUniqueAnswer(int given) {
        return !answers.contains(given);
    }
}
