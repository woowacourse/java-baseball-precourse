package baseball;

public class Output {

	public static void printResult(int strike, int ball) {
		if (ball > 0 && strike > 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		} else if (ball > 0) {
			System.out.println(ball + "볼 ");
		} else if (strike > 0) {
			System.out.println(strike + "스트라이크");
		} else if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		}
	}
}
