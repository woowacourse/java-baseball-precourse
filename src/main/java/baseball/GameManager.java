package baseball;

public class GameManager {

    private static final int EXIT_CODE = 2;

    private final Computer computer;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public GameManager(
        Computer computer,
        InputHandler inputHandler,
        OutputHandler outputHandler
    ) {
        this.computer = computer;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void start() {
        while(true) {
            initialize();
            play();

            int decision = askRestart();
            if(exitIsSelected(decision)) {
                outputHandler.printExitMessage();
                return;
            }
        }
    }

    private void initialize() {
        computer.initialize();
        outputHandler.printStartMessage();
    }

    private void play() {
        while(true) {
            outputHandler.printNumberInputMessage();
            int[] input = inputHandler.readUserEstimation();

            JudgeResult result = computer.judge(input);
            outputHandler.printJudgeResult(result);
            if(result.isCorrect()) {
                outputHandler.printWinningMessage();
                break;
            }
        }
    }

    private int askRestart() {
        outputHandler.printSelectStartOrExitMessage();
        return inputHandler.readGameExitDecision();
    }

    private static boolean exitIsSelected(int decision) {
        return decision == EXIT_CODE;
    }
}
