package baseballgame;
import java.util.Random;
import java.util.ArrayList;

public class Computer {
	private static final int BALL_LEN = 3;
	private static final int MAX_NUM = 9;
	Random random = new Random();
	ArrayList<Integer> randomNums = new ArrayList<Integer>(BALL_LEN);
	
	public void makeRandomNums() {
		randomNums.clear();
		while (true) {
			if(randomNums.size() == BALL_LEN) { break; }
			int randomNum = random.nextInt(MAX_NUM) + 1;
			if (randomNums.contains(randomNum)) {
				continue;
			}
			randomNums.add(randomNum);
		}
	}
}
