package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.builder.RandomDigitsBuilder;

public class Computer {
	private final List<Integer> numberList;
	private final Map<Integer, Integer> numberOccurrences;

	public Computer() {
		this(RandomDigitsBuilder.getRandomDigitList());
	}

	public Computer(List<Integer> numberList) {
		this.numberList = numberList;
		this.numberOccurrences = new HashMap<>();
		for (int i = 0; i < numberList.size(); i++)
			numberOccurrences.put(numberList.get(i), i);
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

	public Map<Integer, Integer> getNumberOccurrences() {
		return numberOccurrences;
	}
}
