package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        //TODO: 숫자 야구 게임 구현
        NumberValidator validator = new ThreeDigitValidator();
        Computer computer = new Computer(new ThreeDigitGenerator(), validator);
        User user = new User();
        Checker checker = new GameChecker();
        int restart;

        do {
            processGame(computer, user, checker, validator);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String input = Console.readLine();
            List<Integer> parsedInput = parseInput(input);
            if(parsedInput.size() != 1) {
                throw new IllegalArgumentException();
            }
            restart = parsedInput.get(0);

        } while(restart != 2);
    }

    public static void processGame(Computer computer, User user, Checker checker, NumberValidator validator) {
        computer.generateNumber();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();

            List<Integer> inputNumbers = parseInput(inputString);
            validateInput(validator, inputNumbers);
            user.setNumbers(inputNumbers);

            int strikes = checker.checkStrike(computer.getNumber(), user.getNumbers());
            int balls = checker.checkBall(computer.getNumber(), user.getNumbers());
            printResult(strikes, balls);
            if(strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

        } while(true);
    }

    public static void validateInput(NumberValidator validator, List<Integer> inputNumbers) {
        if(!validator.validateNumber(inputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parseInput(String string) {
        List<Integer> parsedInput = new ArrayList<>(3);
        int stringLen = string.length();
        for (int index = 0; index < stringLen; index++) {
            char charAtIndex = string.charAt(index);
            isDigit(charAtIndex);
            parsedInput.add(Character.getNumericValue(charAtIndex));
        }
        return parsedInput;
    }

    public static void isDigit(char character) {
        if(!Character.isDigit(character)) {
            throw new IllegalArgumentException();
        }
    }

    public static void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes > 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else if (strikes == 0 && balls > 0) {
            System.out.println(balls + "볼");
        } else if (strikes > 0 && balls > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }
}
