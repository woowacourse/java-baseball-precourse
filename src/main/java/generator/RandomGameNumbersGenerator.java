package generator;

import static domain.BaseBallGame.*;
import static domain.BaseBallNumber.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGameNumbersGenerator implements GameNumbersGenerator {
	private List<Integer> numberList = new ArrayList();

	public RandomGameNumbersGenerator() {
		this.numberList = IntStream.range(MIN_NUM, MAX_NUM)
			.boxed()
			.collect(Collectors.toList());
	}

	public List<Integer> getGeneratedNumbers() {
		Collections.shuffle(this.numberList);
		return this.numberList.subList(0, GAME_NUMBERS_SIZE);
	}

}
