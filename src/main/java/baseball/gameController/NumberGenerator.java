package baseball.gameController;

import java.util.HashSet;
import java.util.Iterator;

public class NumberGenerator {

	private HashSet<Integer> generateNumSet() {
		HashSet<Integer> selectedNum = new HashSet<>();

		while (selectedNum.size() < 3) {
			int randomNum = (int)(Math.random() * 10) % 9 + 1;
			selectedNum.add(randomNum);
		}

		return selectedNum;
	}

	public int generateNumber() {
		Iterator<Integer> iterator = generateNumSet().iterator();

		return iterator.next() * 100 + iterator.next() * 10 + iterator.next();
	}
}
