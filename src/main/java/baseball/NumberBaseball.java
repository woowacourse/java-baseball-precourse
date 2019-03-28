
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
import java.util.Scanner;

public class NumberBaseball {
    private static ArrayList<Integer> setAnswer() {
        HashSet<Integer> numbers = new HashSet<>();

        // 1~9 서로 다른 세 숫자 선정
        while (numbers.size() != 3) {
            numbers.add((int) (Math.random() * 9 + 1));
        }

        ArrayList<Integer> correctAnswer = new ArrayList<>(numbers);
        Collections.shuffle(correctAnswer);

        System.out.println(correctAnswer);

        return correctAnswer;
    }

    private static ArrayList<Integer> changeFormat(int input) {
        ArrayList<Integer> userAnswer = new ArrayList<>();

        while (input != 0) {
            userAnswer.add(0, input % 10);
            input /= 10;
        }

        return userAnswer;
    }

    private static String judgeAnswer(ArrayList<Integer> userAnswer,
                                      ArrayList<Integer> correctAnswer) {

        // 스트라이크 & 볼 판단
        int ball = 0;
        int strike = 0;
        int index = 0;

        for (int e : userAnswer) {
            if (userAnswer.get(index).equals(correctAnswer.get(index))) {
                strike++;
            } else if (correctAnswer.contains(e)) {
                ball++;
            }
            index++;
        }

        String result;

        if ((ball == 0) && (strike == 0)) {
            result = "낫싱";
        } else if (strike == 0) {
            result = ball + "볼";
        } else if (ball == 0) {
            result = strike + "스트라이크";
        } else {
            result = strike + "스트라이크 " + ball + "볼";
        }

        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        boolean keepGoing = true;

        while (keepGoing) {
            ArrayList<Integer> correctAnswer = setAnswer();

            // 사용자가 유추한 정답 입력
            String result = "";

            while (!result.equals("3스트라이크")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("숫자를 입력해주세요 : ");
                int input = scanner.nextInt();

                ArrayList<Integer> userAnswer = changeFormat(input);

                result = judgeAnswer(userAnswer, correctAnswer);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니! 게임 종료");

            Scanner scanner = new Scanner(System.in);
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. \n");
            int input = scanner.nextInt();

            if (input == 2) {
                System.out.println("게임을 완전히 종료합니다.");
                keepGoing = false;
            }

            scanner.close();
        }
    }
}
