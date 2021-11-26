package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
	private static final int DIGIT = 3;
	private String ranNum;
	
	public Computer () {
		ranNum = "";
	}
	
	public void initialize () {
		ranNum = generateRanNum(DIGIT);
	}
	
	private String generateRanNum(int digit) {
		ArrayList <Character> list = new ArrayList<>();
		String res = "";
		while(list.size()<digit) {
			char tmp = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);
			
			if(list.contains(tmp)) {
				continue;
			}
			list.add(tmp);
		}
		for(char c : list) {
			res += c;
		}
		return res;
	}
	
}
