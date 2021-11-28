package baseball;

import baseball.game.GameService;
import baseball.player.PlayerService;
import baseball.utils.InputUtils;
import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameSystem {

    public static final int GAME_RE_START = 1;
    public static final int GAME_EXIT = 2;
    public static final int GAME_MENU_LENGTH = 1;
    public static final String USER_WIN = "3스트라이크";

    private PlayerService playerService;
    private GameService gameService;

    public void play() {
        playerService = PlayerService.getInstance();
        gameService = GameService.getInstance();

        while(true) {
            playPhase();

            if(isGameExit()) {
                break;
            }
        }
    }

    private void playPhase() {
        playerService.setComputerGameRandomDigits();

        while(true) {
            List<Integer> userGameDigits = getInputDigits();
            playerService.setUserGameInputDigits(userGameDigits);

            playerService.computeGameScore();

            int strikeScore = playerService.getStrikeScore();
            int ballScore = playerService.getBallScore();
            String gameResult = gameService.getGameResult(strikeScore, ballScore);
            System.out.println(gameResult);

            if(isUserWin(gameResult)){
                break;
            }
        }
    }

    private List<Integer> getInputDigits() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputDigits = Console.readLine();
        InputValidator.validateGameDigits(inputDigits);
        return InputUtils.convertStringToIntegerList(inputDigits);
    }

    private boolean isUserWin(String gameResult) {
        if(gameResult.equals(USER_WIN)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public boolean isGameExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            String input = Console.readLine();
            InputValidator.validateGameMenu(input);
            int nextStep = Character.getNumericValue(input.charAt(0));
            return nextStep == GAME_EXIT;
       }catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
