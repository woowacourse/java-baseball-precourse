package baseball;

public class OutputHandler {

    public void printNumberInputMessage() {
        System.out.println(OutputMessage.NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printEndingMessage() {
        System.out.println(OutputMessage.ENDING_MESSAGE.getMessage());
    }

    public void printRestartMessage() {
        System.out.println(OutputMessage.RESTART_MESSAGE.getMessage());
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
