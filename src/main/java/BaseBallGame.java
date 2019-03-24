import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class BaseBallGame {
	BufferedReader in;
	Random random;
	boolean[] picked;
	int[] targetNo;
	int pickCount;
	
	
	
	public BaseBallGame() {
		in = new BufferedReader(new InputStreamReader(System.in));
		random = new Random();
		picked = new boolean[10];
		targetNo = new int[3];
		pickCount = 0;
	}

	private void init() {
		for(int i = 0; i < 10; i++) {
			picked[i] = false;
		}
		pickCount = 0;
		
		while(pickCount < 3) {
			int currentPick = random.nextInt(10);
			if(!picked[currentPick]) {
				targetNo[pickCount++] = currentPick;
				picked[currentPick] = true;
			}
		}
	}
}
