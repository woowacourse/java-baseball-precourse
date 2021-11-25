package baseball;

public class BaseballSystem {
	public int[] computerNums;

	public BaseballSystem() {
		computerNums = new ComputerNumGenerator().nums;
	}

	public void gameStart() {
		do {
			int[] userNums = new UserNumGenerator().nums;
			BaseballCount set = new BaseballCount(userNums, computerNums);

			if (set.strikeCount == 3) {
				System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
			if (set.ballCount != 0) {
				System.out.print(set.ballCount + "볼 ");
			}
			if (set.strikeCount != 0) {
				System.out.print(set.strikeCount + "스트라이크");
			}
			if (set.ballCount == 0 && set.strikeCount == 0) {
				System.out.print("낫싱");
			}
			System.out.println();
		} while (true);
	}
}
