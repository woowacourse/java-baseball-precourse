
/*
 * NumberBaseball
 *
 * ver 1.0
 *
 * 2019/03/28
 *
 * Copyright 2019. Jieun Jeong. All ringts reserved.
 */

package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class NumberBaseball {
    public static boolean isThisStringNumber(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print("숫자가 아닙니다.");
            return false;
        }
    }

    public static List<Integer> adjustFormat(String numbers) {
        List<Integer> userAnswer = new ArrayList<>();

        if (isThisStringNumber(numbers)) {
            int number = Integer.parseInt(numbers);
            while (number != 0) {
                userAnswer.add(0, number % 10);
                number /= 10;
            }
        } else {
            inputInferNumbers();
        }

        return userAnswer;
    }

    public static Numbers inputInferNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");

        try {
            String input = scanner.nextLine();
            Numbers numbers = new Numbers(adjustFormat(input));
            return numbers;
        } catch (IllegalArgumentException e) {
            return inputInferNumbers();
        }
    }

    public static WinningNumbers setWinningNumbers() {
        int NUMBER_LENGTH = 3;
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() != NUMBER_LENGTH) {
            numbers.add((int) (Math.random() * 9 + 1));
        }

        List<Integer> correctAnswer = new ArrayList<>(numbers);
        Collections.shuffle(correctAnswer);
        WinningNumbers winningNumbers = new WinningNumbers(correctAnswer);

        return winningNumbers;
    }

    public static boolean isContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. \n");
        int input = scanner.nextInt();

        if (input == 2) {
            System.out.println("게임을 완전히 종료합니다.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean keepGoing = true;

        while (keepGoing) {
            WinningNumbers winningNumbers = setWinningNumbers();
            boolean result = false;

            while (!result) {
                Numbers inferNumbers = inputInferNumbers();
                result = winningNumbers.matchResult(inferNumbers);
            }

            keepGoing = isContinue();
        }
    }
}
