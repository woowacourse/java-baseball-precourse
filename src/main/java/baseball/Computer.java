package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;

public class Computer {
	public static final int NUMBER_DIGIT= 3;
	public static final int MIN_RANGE= 1;
	public static final int MAX_RANGE= 9;
	private ArrayList<Integer> ranNumList;

	public Computer() {
	}
	
	public void init() {
		genRandomNumber();
	}
	
	//generate random numbers > ranNumList
	private void genRandomNumber() {
		ranNumList= new ArrayList<>();
		while(ranNumList.size()<=NUMBER_DIGIT) {
			int num= (pickNumberInRange(1, 9));
			if(!ranNumList.contains(num)) {
				ranNumList.add(num);
			}
		}
	}
	
	//useNumList:사용자 입력값과 ranNumList 비교해서 스트라이크 개수 카운팅
	public int cntStrike(ArrayList<Integer> userNumList) {
		int cnt_strike= 0;
		for(int i=0; i<NUMBER_DIGIT; i++) {
			if(userNumList.get(i)==ranNumList.get(i)) {
				cnt_strike++;
			}
		}
		return cnt_strike;
	}
	
	//userNumList:사용자 입력값과 ranNumList 비교해서 볼 개수 카운팅
	public int cntBall(ArrayList<Integer> userNumList) {
		int cnt_Ball= 0;
		for(int i=0; i<NUMBER_DIGIT; i++) {
			if(userNumList.get(i)!=ranNumList.get(i)
					&&ranNumList.contains(userNumList.get(i))) {
				cnt_Ball++;
			}
		}
		return cnt_Ball;
	}
	
	

}
