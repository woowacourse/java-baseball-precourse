package baseball;

public class GameManager {

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
            computer.initialize();
            outputHandler.printStartMessage();

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

            outputHandler.printSelectStartOrExitMessage();
            int decision = inputHandler.readGameExitDecision();
            if(decision == 2) {
                outputHandler.printExitMessage();
                break;
            }
        }
    }
}
