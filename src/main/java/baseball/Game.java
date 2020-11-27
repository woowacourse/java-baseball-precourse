package baseball;

import baseball.domain.Computer;
import utils.InputUtils;

import java.util.List;
import java.util.Scanner;

public class Game {

    private final int GAME_START_CODE = 1;

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        while (true) {
            playingPhase();

            if (!isContinue()) {
                break;
            }
        }
    }

    private void playingPhase() {
        Computer computer = new Computer();

        while (true) {
            List<Integer> userBaseballInput = getUserBaseballInput();

            String gameResult = computer.guessTargetDigits(userBaseballInput);
            System.out.println(gameResult);

            if (isGameEnd(gameResult)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private boolean isGameEnd(String gameResult) {
        return gameResult.equals("3스트라이크");
    }

    private boolean isContinue() {
        int userInput = getUserMenuInput();

        if (userInput == GAME_START_CODE) {
            return true;
        } else {
            return false;
        }
    }

    private List<Integer> getUserBaseballInput() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = scanner.nextLine();

            if (!InputUtils.isDigit(input)) {
                System.out.println("※ 숫자만 입력해주세요.");
                continue;
            }

            if (!InputUtils.isInputLengthEqualsToBaseballLength(input)) {
                System.out.println("※ 3자리의 숫자를 입력해주세요.");
                continue;
            }

            if (!InputUtils.isDigitInBaseballRange(input)) {
                System.out.println("※ 1부터 9사이의 숫자만 입력해주세요.");
                continue;
            }

            return InputUtils.convertStringToIntegerList(input);
        }
    }

    private int getUserMenuInput() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String input = scanner.nextLine();

            if (!InputUtils.isDigit(input)) {
                System.out.println("※ 숫자만 입력해주세요.");
            }

            if( !InputUtils.isDigitInMenuRange(input)) {
                System.out.println("※ 1 혹은 2만 입력해주세요.");
                continue;
            }

            return Integer.parseInt(input);
        }
    }
}
