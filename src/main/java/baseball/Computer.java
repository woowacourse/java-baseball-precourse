package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;

public class Computer {
	public static final int NUMBER_DIGIT= 3;
	public static final int MIN_RANGE= 1;
	public static final int MAX_RANGE= 9;

	public Computer() {
	}
	
	public void init() {
		genRandomNumber();
	}
	
	//generate random numbers > ranNumList
	private void genRandomNumber() {
		ArrayList<Integer> ranNumList= new ArrayList<>();
		while(ranNumList.size()<=NUMBER_DIGIT) {
			int num= (pickNumberInRange(1, 9));
			if(!ranNumList.contains(num)) {
				ranNumList.add(num);
			}
		}
	}

}
