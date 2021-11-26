package baseball;

import java.util.List;

public class Computer {
	private final BallRepository ballRepository = new BallRepository();

	public Computer() {
		RandomNumbers randomNumbers = new RandomNumbers();
		ballRepository.insertNumbers(randomNumbers.getNumberList());
	}

	public void createNewNumbers() {
		RandomNumbers randomNumbers = new RandomNumbers();
		ballRepository.clearNumbers();
		ballRepository.insertNumbers(randomNumbers.getNumberList());
	}

	public List<Ball> getBalls() {
		return ballRepository.getBalls();
	}
}
