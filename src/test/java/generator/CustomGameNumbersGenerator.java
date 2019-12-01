package generator;

import java.util.ArrayList;
import java.util.List;

public class CustomGameNumbersGenerator implements GameNumbersGenerator {

	private List<Integer> numbers = new ArrayList<>();

	CustomGameNumbersGenerator(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getGeneratedNumbers() {
		return this.numbers;
	}

}
