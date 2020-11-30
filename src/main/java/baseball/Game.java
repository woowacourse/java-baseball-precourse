package baseball;

import baseball.domain.Computer;
import utils.InputUtils;

import java.util.List;
import java.util.Scanner;

/**
 * 게임의 컨트롤 역할을 하는 클래스
 * 두 가지의 책임을 가지고 있습니다.
 * 1. 게임 실행 제어
 * 2. 사용자 입력
 */
public class Game {

    private final int GAME_START_CODE = 1;

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    /** 게임 시작 함수 */
    public void play() {
        while (true) {
            playingPhase();

            if (!isContinue()) {
                break;
            }
        }
    }

    /** 게임의 한 라운드(숫자 야구 게임 한판) 시작 함수 */
    private void playingPhase() {
        Computer computer = new Computer();

        while (true) {

            List<Integer> userBaseballInput;

            try {
                userBaseballInput = getUserBaseballInput();
            } catch (IllegalArgumentException e) {
                continue;
            }

            String gameResult = computer.guessTargetDigits(userBaseballInput);
            System.out.println(gameResult);

            if (isGameEnd(gameResult)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    /** 게임의 한 라운드가 끝났는지 확인하는 함수 */
    private boolean isGameEnd(String gameResult) {
        return gameResult.equals("3스트라이크");
    }

    /** 게임의 한 라운드가 끝나고 새로운 라운드를 진행할지 확인하는 함수 */
    private boolean isContinue() {
        while (true) {
            int userInput;

            try {
                userInput = getUserMenuInput();
            } catch (IllegalArgumentException e) {
                continue;
            }

            if (userInput == GAME_START_CODE) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** 게임 플레이에 대한 사용자 입력을 받는 함수 */
    private List<Integer> getUserBaseballInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = scanner.nextLine();

        if (!InputUtils.isDigit(input)
                ||!InputUtils.isInputLengthEqualsToBaseballLength(input)
                ||!InputUtils.isDigitInBaseballRange(input)) {
            throw new IllegalArgumentException();
        }

        return InputUtils.convertStringToIntegerList(input);
    }

    /** 게임 메뉴에 대한 사용자 입력을 받는 함수 */
    private int getUserMenuInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = scanner.nextLine();

        if (!InputUtils.isDigit(input) ||!InputUtils.isDigitInMenuRange(input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }
}
