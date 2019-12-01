package domain;

import java.util.List;

import domain.baseBalls.AnswerBaseBalls;
import domain.baseBalls.QuestionBaseBalls;
import generator.GameNumbersGenerator;
import io.InputView;
import io.OutputView;
import parsing.NumberParsing;

public class BaseBallGame {
	public static final int GAME_NUMBERS_SIZE = 3;

	private AnswerBaseBalls collectBaseBalls;

	public BaseBallGame(GameNumbersGenerator gameNumbersGenerator) {
		this.collectBaseBalls = AnswerBaseBalls.ofGenerator(gameNumbersGenerator);
	}

	public void executeUserInput(InputView inputView) {
		this.collectBaseBalls.print();
		QuestionBaseBalls.Result result;
		do {
			result = getQuestionBaseBall(inputView).getCalculateResult(this.collectBaseBalls);
			OutputView.getBaseBallsResult(result);
		} while (wrongAnswer(result));
		OutputView.endOfOneBaseBallGame();

	}

	private boolean wrongAnswer(QuestionBaseBalls.Result result) {
		return result.getStrike() != GAME_NUMBERS_SIZE;
	}

	private QuestionBaseBalls getQuestionBaseBall(InputView inputView) {
		List<Integer> integers = NumberParsing.makeNumbersFromString(inputView.getNumbers());
		return QuestionBaseBalls.ofManual(integers);
	}

}
