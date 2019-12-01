package generator;

import static domain.BaseBallNumber.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGameNumbersGenerator implements GameNumbersGenerator {
	private final int GAME_NUMBER_COUNT = 3;

	private List<Integer> numberList = new ArrayList();
	private Random random = new Random();

	RandomGameNumbersGenerator() {
		this.numberList = IntStream.range(MIN_NUM, MAX_NUM)
			.boxed()
			.collect(Collectors.toList());
	}

	public List<Integer> getGeneratedNumbers() {
		Collections.shuffle(this.numberList);
		return this.numberList.subList(0, GAME_NUMBER_COUNT);
	}

}
