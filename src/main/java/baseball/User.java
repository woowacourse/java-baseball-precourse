package baseball;

import java.util.HashSet;
import camp.nextstep.edu.missionutils.Console;

public class User {
	private static final int DIGIT = 3;
	private static final String numRegex = "^[1-9]{3}$";
	
	public User () {
		
	}
	
	public String userNumber() {
		String num = Console.readLine();
		
		if(!num.matches(numRegex)) {
			throw new IllegalArgumentException();
		}
		if(!hasSame(num)) {
			throw new IllegalArgumentException();
		}
		return num;
	}
	
	private boolean hasSame(String tar) {
		HashSet<Character> set = new HashSet<>();
		char [] charArr = tar.toCharArray();
		for(int i=0;i<DIGIT;i++) {
			set.add(charArr[i]);
		}
		if(set.size()==DIGIT) {
			return true;
		}
		return false;
	}

}
