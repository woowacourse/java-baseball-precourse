package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Computer {
	private List<Integer> numberList;
	private Map<Integer, Integer> numberOccurrences;

	public Computer(List<Integer> numberList) {
		this.numberList = numberList;
		buildNumberOccurrences(numberList);
	}

	private void buildNumberOccurrences(List<Integer> numberList) {
		this.numberOccurrences = new HashMap<>();
		IntStream.range(0, numberList.size()).forEach(i -> numberOccurrences.put(numberList.get(i), i));
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

	public void setNumberList(List<Integer> numberList) {
		this.numberList = numberList;
		buildNumberOccurrences(numberList);
	}

	public Map<Integer, Integer> getNumberOccurrences() {
		return numberOccurrences;
	}
}
