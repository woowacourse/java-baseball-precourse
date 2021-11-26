package baseball.gameController;

import java.util.HashSet;

import camp.nextstep.edu.missionutils.Console;

public class GameDriver {
	NumberGenerator numberGenerator = new NumberGenerator();
	HintGiver hintGiver = new HintGiver();
	String answer = "";

	public void run() {
		do {
			play();
			askResume();
		} while (answer.equals("1"));
	}

	private void play() {
		hintGiver.initHint();
		HashSet<Integer> realAnswer = numberGenerator.generateNumSet();
		int playerAnswer;
		while (!hintGiver.hint.equals("3스트라이크")) {
			System.out.print("숫자를 입력해주세요 : ");
			playerAnswer = Integer.parseInt(Console.readLine());
			hintGiver.setScore(realAnswer, playerAnswer);
			hintGiver.getHint();
			System.out.println(realAnswer);
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private void askResume() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		this.answer = Console.readLine();
	}
}
