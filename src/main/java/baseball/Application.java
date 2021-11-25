package baseball;

public class Application {
	public static void main(String[] args) {
		int[] computerNums = new ComputerNumGenerator().nums;
		int[] userNums = new UserNumGenerator().nums;
	}
}