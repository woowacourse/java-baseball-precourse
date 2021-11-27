package baseball;

import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Enemy {
	public Enemy() {

	}

	public void setEnemyNum(int[] enemyNum) {
		int index = 0;
		while (index < 3) {
			int temp = Randoms.pickNumberInRange(1, 9);
			if (!IntStream.of(enemyNum).anyMatch(x -> temp == x)) {
				enemyNum[index] = temp;
				index++;
			}
		}
	}
}
