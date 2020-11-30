package baseball.controller;

import java.util.List;
import java.util.Scanner;

import static utils.Validator.REQUIRE_NUMBER_COUNT;

public class GameController {

    private static Computer computer;
    private static InputController inputController;

    private static int GAME_SUCCESS_COUNT = 3;

    public static void testPring() {    //TODO 테스트용 삭제 필수
        List<Integer> integers = computer.cloneNumbers();
        System.out.println(integers.toString());
    }

    public GameController(Scanner scanner) {
        this.inputController = new InputController(scanner);
    }

    public void run() {

        initComputer();

        testPring(); //TODO 정답용 프린터 꼭 삭제 프린터 꼭 삭제

        initPlayerInput();

    }


    private void initComputer() {
        this.computer = Computer.create();
    }

    private static void initPlayerInput() {

        System.out.println("숫자를 입력하세요");
        List<Integer> numbers = inputController.input();

        GameStatus status = checkNumbers(numbers);

        if (status == GameStatus.RETRY) {
            System.out.println("틀렸습니다");
            initPlayerInput();
        }

    }

    private static GameStatus checkNumbers(List<Integer> numbers) {

        int ballCount = checkBall(numbers);
        int strikeCount = checkStrike(numbers);
        System.out.println("볼" + ballCount);
        System.out.println("스트라이크" + strikeCount);
        if (strikeCount != GAME_SUCCESS_COUNT) {
            return GameStatus.RETRY;
        }

        return GameStatus.SUCCESS;
    }

    private static int checkBall(List<Integer> numbers) {
        return getSameNumberCount(numbers) - getStrikeCount(numbers);
    }

    private static int getSameNumberCount(List<Integer> numbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (computer.hasNumber(number)) {
                count++;
            }
        }
        return count;
    }

    private static int checkStrike(List<Integer> input) {
        int strikeCount = getStrikeCount(input);
        return strikeCount;
    }

    private static int getStrikeCount(List<Integer> numbers) {

        int count = 0;
        for (int i = 0; i < REQUIRE_NUMBER_COUNT; i++) {
            int targetNumber = numbers.get(i);
            if (computer.hasNumberOfIndex(targetNumber, i)) {
                count++;
            }
        }
        return count;
    }

}
