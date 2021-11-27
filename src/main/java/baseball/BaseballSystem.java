package baseball;

public class BaseballSystem {
	public int[] computerNums;

	public BaseballSystem() {
		computerNums = new ComputerNumGenerator().nums;
	}

	public void gameStart() {
		boolean threeStrike;
		do {
			BaseballCount set = new BaseballCount(new UserNumGenerator().nums, computerNums);
			printGameResult(set);
			threeStrike = isThreeStrike(set);
		} while (!threeStrike);
	}

	public void printGameResult(BaseballCount set) {
		printOnlyBall(set);
		printOnlyStrike(set);
		printBallAndStrike(set);
		printNoting(set);
	}

	public boolean isThreeStrike(BaseballCount set) {
		if (set.strikeCount == Constant.NUMS_LENGTH) {
			System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

	public void printOnlyBall(BaseballCount set) {
		if (set.ballCount != 0 && set.strikeCount == 0) {
			System.out.println(set.ballCount + "볼");
		}
	}

	public void printOnlyStrike(BaseballCount set) {
		if (set.ballCount == 0 && set.strikeCount != 0) {
			System.out.println(set.strikeCount + "스트라이크");
		}
	}

	public void printBallAndStrike(BaseballCount set) {
		if (set.ballCount != 0 && set.strikeCount != 0) {
			System.out.print(set.ballCount + "볼 " + set.strikeCount + "스트라이크");
		}
	}

	public void printNoting(BaseballCount set) {
		if (set.ballCount == 0 && set.strikeCount == 0) {
			System.out.println("낫싱");
		}
	}
}

