package domain;

import java.util.List;

import domain.baseBalls.AnswerBaseBalls;
import domain.baseBalls.QuestionBaseBalls;
import generator.GameNumbersGenerator;
import io.InputView;
import parsing.NumberParsing;

public class BaseBallGame {
	public static final int GAME_NUMBERS_SIZE = 3;

	private AnswerBaseBalls collectBaseBalls;

	public BaseBallGame(GameNumbersGenerator gameNumbersGenerator, InputView inputView) {
		this.collectBaseBalls = AnswerBaseBalls.ofGenerator(gameNumbersGenerator);
		while (true) {
			getQuestionBaseBall(inputView).getCalculateResult(this.collectBaseBalls);
			break;
		}
	}

	private QuestionBaseBalls getQuestionBaseBall(InputView inputView) {
		List<Integer> integers = NumberParsing.makeNumbersFromString(inputView.getNumbers());
		return QuestionBaseBalls.ofManual(integers);
	}

}
