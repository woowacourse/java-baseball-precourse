package ui;

public class Output {
    public static final String SHOULD_INPUT_ONLY_NUMBER = "숫자만을 입력해야 합니다";
    public static final String SHOULD_NOT_INCLUDE_ZERO = "입력하시는 숫자에는 0이 포함되면 안 됩니다";
    public static final String SHOULD_INPUT_THREE_DIGIT = "입력하시는 숫자에는 0이 포함되면 안 됩니다";
    public static final String SHOULD_NOT_CONTAIN_OVERLAPPED = "세 자리의 숫자에서 각 자리의 숫자에 중복된 숫자가 포함되면 안 됩니다";
    public static final String SHOULD_INPUT_ONLY_ONE_OR_TWO = "숫자 1 또는 2만 입력하셔야 합니다";
    public static final String CORRECT_ANSWER_AND_EXIT_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printRequestNumberInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printRequestRestartGameInput() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printBallOrStrikeCount(int strikeCount, int ballCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }


}
