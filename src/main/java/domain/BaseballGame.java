package domain;

import java.util.List;
import java.util.Objects;

import view.InputView;
import view.OutputView;

public class BaseballGame {
	private final BaseballNumberRepository baseballNumberRepository;
	private boolean isEnd = false;

	public BaseballGame(BaseballNumberRepository baseballNumberRepository) {
		this.baseballNumberRepository = Objects.requireNonNull(baseballNumberRepository);
	}

	public void play() {
		while (!isEnd) {
			List<BaseballNumber> randomNumbers = baseballNumberRepository.randomNumbers();
			result(randomNumbers);
			askRestartGame();
		}
	}

	private void result(List<BaseballNumber> randomNumbers) {
		boolean isMaxStrikeCount = false;
		while (!isMaxStrikeCount) {
			BaseballNumbers baseballNumbers = InputView.getBaseballNumbers();
			Score score = baseballNumbers.score(randomNumbers);
			OutputView.show(score.message());
			isMaxStrikeCount = score.isMaxStrikeCount();
		}
		OutputView.successMessage();
	}

	private void askRestartGame() {
		BaseballGameStatus baseballGameStatus = InputView.getGameStatus();
		if (BaseballGameStatus.EXIT.equals(baseballGameStatus)) {
			OutputView.exitMessage();
			isEnd = true;
			return;
		}
	}
}
