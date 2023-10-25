package service;

import java.util.List;

public class CompareNum {
	public int countBall(List<Integer> computer, List<Integer> user){
		int result = 0;
		for(int i = 0; i < user.size(); i++){
			if(computer.contains(user.get(i))){
				result += 1;
			}
		}
		return result;
	}
	
    public int countStrike(List<Integer> computer, List<Integer> user){
        int strike = 0;
        for(int i = 0; i < user.size(); i++){
            if(computer.get(i) == user.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
    
}
