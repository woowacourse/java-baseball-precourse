package baseball;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Defender {
	private static final int NUM_MIN = 1;
	private static final int NUM_MAX = 9;
	private static final int NUM_SIZE = 3;
	private int number;

	private Defender(int number) {
		this.number = number;
	}

	public static Defender getInstance() {
		return new Defender(shuffle());
	}

	public int getNumber() {
		return number;
	}

	public void changeNumber() {
		number = shuffle();
	}

	private static int shuffle() {
		Set<Integer> set = new HashSet<>();
		while (set.size() < NUM_SIZE) {
			set.add(pickNumberInRange(NUM_MIN, NUM_MAX));
		}
		StringBuilder sb = new StringBuilder();
		for (int num : set) {
			sb.append(num);
		}
		return Integer.parseInt(sb.toString());
	}

}
