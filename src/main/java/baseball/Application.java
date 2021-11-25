package baseball;

public class Application {
	public static void main(String[] args) {
		int[] computerNums = new ComputerNumGenerator().nums;
		do {
			int[] userNums = new UserNumGenerator().nums;
			BaseballCount baseballCount = new BaseballCount(userNums, computerNums);
			if (baseballCount.strikeCount == 3) {
				System.out.println("3스트라이크");
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
			if (baseballCount.ballCount != 0) {
				System.out.print(baseballCount.ballCount + "볼 ");
			}
			if (baseballCount.strikeCount != 0) {
				System.out.print(baseballCount.strikeCount + "스트라이크");
			}
			if (baseballCount.ballCount == 0 && baseballCount.strikeCount == 0) {
				System.out.print("낫싱");
			}
			System.out.println();
		} while (true);
	}
}