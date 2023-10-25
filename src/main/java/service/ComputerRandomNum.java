package service;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerRandomNum {
	
	private List<Integer> computerNumber;
	
	public ComputerRandomNum() {
		computerNumber = setGameNumber();
	}
	
	public List<Integer> getComputerNumber() {
		return computerNumber;
	}
    public static int getComputerNum() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public List<Integer> setGameNumber() {
    	List<Integer> computerNumber = new ArrayList<>();
    	while (computerNumber.size() < 3) {
    		int randomNumber = getComputerNum();
    		if(computerNumber.contains(randomNumber)){
    			continue;
    		}else {
    			computerNumber.add(randomNumber);
    		}
    	}
    	return computerNumber;
    }
   
}
