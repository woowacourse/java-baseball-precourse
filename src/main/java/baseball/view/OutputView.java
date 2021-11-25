package baseball.view;

public class OutputView {
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void outputRefereeResult(String message) {
        System.out.println(message);
    }

    public void outputSuccess() {
        System.out.println(END_MESSAGE);
    }
}