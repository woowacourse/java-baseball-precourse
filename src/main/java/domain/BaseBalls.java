package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBalls {
	private List<OneBaseBall> baseBalls = new ArrayList<>();

	public BaseBalls(List<Integer> numbers) {
		for (int position = 0; position < numbers.size(); position++) {
			Integer number = numbers.get(position);
			this.baseBalls.add(OneBaseBall.ofInteger(number, position));
		}
	}

}
