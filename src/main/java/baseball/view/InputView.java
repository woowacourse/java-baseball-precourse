package baseball.view;

import baseball.domain.computer.GameResult;
import baseball.domain.computer.GameState;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static String INPUT_NUMBERS_DELIMITER = "";

    private static String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String INPUT_GAME_STATE_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputBaseBallNumbers = Console.readLine();
        System.out.println(inputBaseBallNumbers);
        return Arrays.stream(inputBaseBallNumbers.split(INPUT_NUMBERS_DELIMITER))
            .map(Integer::new)
            .collect(Collectors.toList());
    }

    public static GameState inputGameStateCommand(GameResult gameResult) {
        if (!gameResult.isFinished()) {
            return GameState.init();
        }
        System.out.println(GAME_OVER_MESSAGE);
        System.out.println(INPUT_GAME_STATE_COMMAND_MESSAGE);
        return GameState.createByCommand(Integer.parseInt(Console.readLine()));
    }
}
