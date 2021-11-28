package baseball;

import baseball.game.GameService;
import baseball.utils.InputUtils;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameSystem {

    public static final int GAME_RE_START = 1;
    public static final int GAME_EXIT = 2;
    public static final int GAME_MENU_LENGTH = 1;
    public static final String USER_WIN = "3스트라이크";

    public void play() {

        while(true) {
            playPhase();

            if(isGameExit()) {
                break;
            }
        }
    }

    private void playPhase() {
        GameService gameService = new GameService();
        //TODO: computer player 난수 설정 구현

        while(true) {
            List<Integer> userGameDigits = getInputDigits();
            //TODO: 사용자 입력 데이터 설정 구현

            String gameResult = gameService.getGameResult();
            System.out.println(gameResult);

            if(isUserWin(gameResult)){
                break;
            }
        }
    }

    private List<Integer> getInputDigits() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputDigits = Console.readLine();
        //TODO: 3자리 입력에 대한 검증 구현
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
            //TODO: 1자리 입력에 대한 검증 구현
            int nextStep = Character.getNumericValue(input.charAt(0));
            return nextStep == GAME_EXIT;
       }catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
