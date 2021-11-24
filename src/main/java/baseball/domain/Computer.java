package baseball.domain;

import java.util.List;

import baseball.builder.RandomDigitsBuilder;

public class Computer {

	private final List<Integer> numberList;

	public Computer() {
		this(RandomDigitsBuilder.getRandomDigitList());
	}

	public Computer(List<Integer> numberList) {
		this.numberList = numberList;
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
