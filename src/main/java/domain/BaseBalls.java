package domain;

import java.util.ArrayList;
import java.util.List;

import generator.GameNumbersGenerator;
import lombok.Getter;

@Getter
public class BaseBalls {
	private List<OneBaseBall> baseBalls = new ArrayList<>();

	BaseBalls(List<Integer> numbers) {
		for (int position = 0; position < numbers.size(); position++) {
			Integer number = numbers.get(position);
			this.baseBalls.add(OneBaseBall.ofInteger(number, position));
		}
	}

	public static BaseBalls of(GameNumbersGenerator generator) {
		return new BaseBalls(generator.getGeneratedNumbers());
	}

	public OneBaseBall findBaseBallByPosition(Integer position) {
		return this.baseBalls.stream()
			.filter(ball -> ball.getBaseBallPosition().equals(position))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않은 position 입니다."));
	}

}
