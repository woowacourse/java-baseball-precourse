package domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class BaseBalls {
	private List<OneBaseBall> baseBalls = new ArrayList<>();

	private BaseBalls(List<Integer> numbers) {
		for (int position = 0; position < numbers.size(); position++) {
			Integer number = numbers.get(position);
			this.baseBalls.add(OneBaseBall.ofInteger(number, position));
		}
	}

	public static BaseBalls of(List<Integer> numbers) {
		return new BaseBalls(numbers);
	}

	public OneBaseBall findBaseBallByPosition(Integer position) {
		return this.baseBalls.stream()
			.filter(ball -> ball.getBaseBallPosition().equals(position))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않은 position 입니다."));
	}

}
