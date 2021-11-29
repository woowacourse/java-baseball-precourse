package baseball;

import static util.Constants.*;

import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Enemy {
	private static final Enemy enemy = new Enemy();

	private Enemy() {

	}

	public static Enemy getEnemy() {
		return enemy;
	}

	public void setEnemyNum(int[] enemyNum) {
		int index = 0;
		while (index < GAME_NUMBER_LENGTH) {
			int temp = Randoms.pickNumberInRange(1, 9);
			if (IntStream.of(enemyNum).noneMatch(x -> temp == x)) {
				enemyNum[index] = temp;
				index++;
			}
		}
	}
}
