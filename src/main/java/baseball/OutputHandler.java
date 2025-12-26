package baseball;

public class OutputHandler {

    public void printNumberInputMessage() {
        System.out.println(OutputMessage.NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printWinningMessage() {
        System.out.println(OutputMessage.WINNING_MESSAGE.getMessage());
    }

    public void printSelectStartOrExitMessage() {
        System.out.println(OutputMessage.SELECT_START_OR_EXIT_MESSAGE.getMessage());
    }

    public void printJudgeResult(JudgeResult judgeResult) {
        System.out.println(judgeResult.getResultMessage());
    }

    public void printStartMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }

    public void printExitMessage() {
        System.out.println(OutputMessage.EXIT_MESSAGE.getMessage());
    }
}
