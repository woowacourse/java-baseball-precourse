package domain.baseBalls;

import java.util.List;

import generator.GameNumbersGenerator;

public class AnswerBaseBalls extends BaseBalls {

	private AnswerBaseBalls(List<Integer> numbers) {
		super(numbers);
	}

	public static AnswerBaseBalls ofGenerator(GameNumbersGenerator generator) {
		return new AnswerBaseBalls(generator.getGeneratedNumbers());
	}

	public void print() {
		this.getBaseBalls().stream().forEach(x -> {
			System.out.println(
				String.format("pos : %d, value : %d", x.getBaseBallPosition(), x.getBaseBallNumber().getValue()));
		});
	}
}
