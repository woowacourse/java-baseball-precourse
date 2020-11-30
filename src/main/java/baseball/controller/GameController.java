package baseball.controller;

import java.util.List;
import java.util.Scanner;

import static utils.Validator.REQUIRE_NUMBER_COUNT;

public class GameController {

    private static Computer computer;
    private static InputController inputController;
    private static ConsoleView consoleView = new ConsoleView();

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

        isRestart();


    }

    private void initComputer() {
        this.computer = Computer.create();
    }

    private static void initPlayerInput() {

        List<Integer> numbers = inputController.input();

        GameStatus status = checkNumbers(numbers);

        if (status == GameStatus.RETRY) {
            initPlayerInput();
        }

    }

    private static GameStatus checkNumbers(List<Integer> numbers) {

        checkBall(numbers);
        int strikeCount = checkStrike(numbers);

        consoleView.printResult();
        if (strikeCount < GAME_SUCCESS_COUNT) {
            return GameStatus.RETRY;
        }

        return GameStatus.SUCCESS;
    }

    private static int checkBall(List<Integer> numbers) {
        int ballCount = getSameNumberCount(numbers) - getStrikeCount(numbers);
        consoleView.setBallCount(ballCount);
        return ballCount;
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
        consoleView.setStrikeCount(strikeCount);
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

    private void isRestart() {
        //TODO 임시:InputConroller,ConsoleView에 기능 추가
        System.out.println("다시?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        GameStatus gameStatus ;
        if(input.equals("1")){
            gameStatus = GameStatus.RESTART;
        }else {
            gameStatus = GameStatus.END;
        }
        //TODO 여기까지 구현

        if (gameStatus == GameStatus.RESTART) {
            run();
        }
    }

}
