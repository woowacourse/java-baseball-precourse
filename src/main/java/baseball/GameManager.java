package baseball;

import baseball.exception.WrongGuessException;

public class GameManager {

    private AnswerGenerator answerGenerator;
    private InputManager inputManager;
    private MarkingManager markingManager;

    public GameManager() {
        answerGenerator = new AnswerGenerator();
        inputManager = new InputManager();
        int[] answerArray = answerGenerator.generateAnswerArray();
        markingManager = new MarkingManager(answerArray);
    }

    public void start() {
        while(true) {
            guess();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restartNum = inputManager.inputRestartNum();
            if (restartNum == 1) {
                restart();
            } else {
                System.exit(0);
            }
        }
    }

    public void restart() {
        int[] newAnswerArray = answerGenerator.generateAnswerArray();
        markingManager.setAnswerArray(newAnswerArray);
    }

    public void guess() {
        while(true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                int[] guessArray = inputManager.inputGuess();
                markingManager.mark(guessArray);
                break;
            } catch (IllegalArgumentException e) {
                // 애플리케이션 종료
                System.exit(0);
            } catch (WrongGuessException e) {
                ;
                // 반복
            }
        }
    }
}
