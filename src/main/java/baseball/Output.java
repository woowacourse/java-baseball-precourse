package baseball;

public class Output {

    private final String TYPE_IN_NUMBERS = "숫자를 입력해주세요 : ";
    private final String CONGRATES = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String TYPE_IN_FOR_MORE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String STRIKE = "스크라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final String SPACE = " ";
    private StringBuilder sb;

    public Output() {
        sb = new StringBuilder();
    }

    public void printAnswerRequest() {
        sb.append(TYPE_IN_NUMBERS);
        System.out.print(sb);
    }

    public void printAskMore() {
        sb.append(CONGRATES).append(TYPE_IN_FOR_MORE);
        System.out.println(sb);
    }

    public void printScore(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            sb.append(ball + BALL).append(SPACE).append(strike + STRIKE);
        } else if (strike != 0 && ball == 0) {
            sb.append(strike + STRIKE);
        } else if (ball != 0 && strike == 0) {
            sb.append(ball + BALL);
        } else {
            sb.append(NOTHING);
        }
        System.out.println(sb);
    }
}
