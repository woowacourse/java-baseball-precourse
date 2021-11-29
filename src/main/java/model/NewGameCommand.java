package model;

import java.util.HashMap;
import java.util.Map;

public class NewGameCommand {
    private static final String NEW_GAME_COMMAND = "1";
    private static final String END_COMMAND = "2";
    private static final Map<String, Boolean> resultByCommand = new HashMap<>();

    static {
        resultByCommand.put(NEW_GAME_COMMAND, true);
        resultByCommand.put(END_COMMAND, false);
    }

    private NewGameCommand() {
    }

    public static boolean willPlayNewGame(String inputValue) {
        validateInputValue(inputValue);
        return resultByCommand.get(inputValue);
    }

    private static void validateInputValue(String inputValue) {
        if (resultByCommand.keySet().stream()
                .noneMatch(command -> command.equals(inputValue))) {
            throw new IllegalArgumentException("재시작 / 종료를 위한 숫자 입력이 잘못 되었습니다.");
        }
    }
}
