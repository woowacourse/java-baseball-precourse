package baseball;

public class OutputView {

    private static final String GAME_START_TEXT="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    private static final String GAME_EXIT_TEXT="게임을 종료합니다";

    private static final String GAME_FINISH_TEXT="3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임종료";

    public static void gameStartText(){
        System.out.println(GAME_START_TEXT);
    }

    public static void gameExitText(){
        System.out.println(GAME_EXIT_TEXT);
    }

    public static void gameFinishText(){
        System.out.println(GAME_FINISH_TEXT);
    }
}
