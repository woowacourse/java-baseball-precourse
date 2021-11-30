package baseball;

import baseball.exception.WrongGuessException;

public class GameManager {

	private AnswerGenerator answerGenerator;
	private InputManager inputManager;
	private MarkingManager markingManager;

	public GameManager() {
		answerGenerator = new AnswerGenerator();
		inputManager = new InputManager();
		// GameManager 객체 생성 시, 정답을 생성하여 markingManager 객체 생성
		int[] answerArray = answerGenerator.generateAnswerArray();
		markingManager = new MarkingManager(answerArray);
	}

	/**
	 * 게임 시작
	 */
	public void start() {
		while (true) {
			guess();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			int restartNum = inputManager.inputRestartNum();
			if (restartNum == 1) {
				restart();
			} else {
				break;
			}
		}
	}

	/**
	 * 게임 재시작, 새로운 정답을 생성하여 markingManager 객체에 set
	 */
	public void restart() {
		int[] newAnswerArray = answerGenerator.generateAnswerArray();
		markingManager.setAnswerArray(newAnswerArray);
	}

	/**
	 * 게임 플레이어가 답을 추측할 수 있도록 함
	 * @throws IllegalArgumentException 잘못된 답을 입력할 경우
	 */
	public void guess() throws IllegalArgumentException {
		while (true) {
			try {
				System.out.print("숫자를 입력해주세요 : ");
				int[] guessArray = inputManager.inputGuess();
				markingManager.mark(guessArray);
				break;
			} catch (WrongGuessException e) {
				; // 반복
			}
		}
	}
}
