package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static int answer1;
    public static int answer2;
    public static int answer3;

    public static void generateNumber() {
        /*
         * answer1, answer2, answer3에 랜덤으로 생성한 변수를 넣어준다.
         */
        answer1 = Randoms.pickNumberInRange(1, 9);
        while (true) {
            answer2 = Randoms.pickNumberInRange(1, 9);
            if (answer2 != answer1) {
                break;
            }
        }
        while (true) {
            answer3 = Randoms.pickNumberInRange(1, 9);
            if ((answer1 != answer3) && (answer2 != answer3)) {
                break;
            }
        }
    }

    public static int[] getUserInput() {
        String inputNumber = Console.readLine();

        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return new int[]{
                inputNumber.charAt(0) - '0',
                inputNumber.charAt(1) - '0',
                inputNumber.charAt(2) - '0'
        };
    }

    public static boolean checkAnswer(int[] inputNumber) {
        return (inputNumber[0] == answer1) && (inputNumber[1] == answer2) && (inputNumber[2] == answer3);
    }

    public static void printStrikeBall(int[] inputNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        StringBuilder printString = new StringBuilder();

        if (answer1 == inputNumber[0]) {
            strikeCount++;
        } else if (answer2 == inputNumber[0] || answer3 == inputNumber[0]) {
            ballCount++;
        }

        if (answer2 == inputNumber[1]) {
            strikeCount++;
        } else if (answer1 == inputNumber[1] || answer3 == inputNumber[1]) {
            ballCount++;
        }

        if (answer3 == inputNumber[2]) {
            strikeCount++;
        } else if (answer1 == inputNumber[2] || answer2 == inputNumber[2]) {
            ballCount++;
        }

        if (ballCount > 0) {
            printString.append(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            printString.append(strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            printString.append("낫싱");
        }

        System.out.println(printString);
    }


    public static void main(String[] args) {

    }
}
