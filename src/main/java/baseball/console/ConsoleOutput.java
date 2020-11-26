package baseball.console;

import baseball.domain.game.GameStatus;
import baseball.domain.judge.JudgeResult;
import baseball.domain.judge.Judgement;
import baseball.domain.judge.judgeRule.JudgeRule;
import baseball.domain.judge.judgeRule.JudgeRuleFactory;
import baseball.domain.judge.judgeRule.NothingJudgeRule;
import baseball.domain.pitching.Pitchings;

public final class ConsoleOutput {

    private static final String INPUT_PITCHINGS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WINNING_MESSAGE = Pitchings.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEXT_GAME_STATUS_MESSAGE =
        "게임을 새로 시작하려면 " + GameStatus.RUN.getValue() +
            ", 종료하려면 " + GameStatus.EXIT.getValue() + "를 입력하세요.";

    private ConsoleOutput() {
    }

    public static ConsoleOutput basic() {
        return new ConsoleOutput();
    }

    public void printInputPitchingsMessage() {
        print(INPUT_PITCHINGS_MESSAGE);
    }

    public void printWinningMessage() {
        println(WINNING_MESSAGE);
    }

    public void printNextGameStatusMessage() {
        println(NEXT_GAME_STATUS_MESSAGE);
    }

    public void println(final JudgeResult judgeResult) {
        if (judgeResult.isNothing()) {
            println(Judgement.NOTHING.getKoreanName());
            return;
        }

        println(convertJudgeResultToString(judgeResult));
    }

    private String convertJudgeResultToString(final JudgeResult judgeResult) {
        StringBuilder resultStr = new StringBuilder();
        for (JudgeRule judgeRule : JudgeRuleFactory.getAll()) {
            if (judgeRule == NothingJudgeRule.getInstance()) {
                continue;
            }

            Judgement judgement = Judgement.get(judgeRule);
            if (!judgeResult.has(judgement)) {
                continue;
            }

            resultStr.append(judgeResult.get(judgement))
                .append(judgement.getKoreanName())
                .append(" ");
        }

        return resultStr.toString();
    }

    public void print(final String value) {
        System.out.print(value);
    }

    public void println(final String value) {
        System.out.println(value);
    }
}
