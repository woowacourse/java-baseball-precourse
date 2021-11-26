package baseball;

public class BaseballGameResult {

    private static final String BASEBALL_GAME_RIGHT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public boolean checkRightAnswer(String hint) {
        if (hint.equals("3스트라이크")) {
            System.out.println(BASEBALL_GAME_RIGHT_ANSWER_MESSAGE);
            return true;
        }
        return false;
    }
}
