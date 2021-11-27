package baseball.number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import baseball.model.BaseballFactory;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber implements BaseballFactory {
	@Override
	public List<Integer> createBaseballNumbers() {
		List<Integer> computerBaseballNumbers = new ArrayList<>();

		while (computerBaseballNumbers.size() != VALID_BASEBALL_NUMBER_SIZE) {
			int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			int length = computerBaseballNumbers.size();

			if (isValidDuplicate(number, computerBaseballNumbers, length) == true) {
				computerBaseballNumbers.add(number);
			}

		}

		return computerBaseballNumbers;
	}

	private static boolean isValidDuplicate(int number, List<Integer> computerBaseballNumbers, int length) {
		if (IntStream.range(START_INDEX, length)
			.filter(i -> computerBaseballNumbers.get(i).equals(number))
			.count() == EXIST_NUMBER) {
			return false;
		} else {
			return true;
		}

	}

}
