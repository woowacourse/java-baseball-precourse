package service;

import java.util.List;

public class JudgeResult {
	
	CompareNum compare = new CompareNum();
	
    public String judgement(List<Integer> computer, List<Integer> player){
        int total = compare.countBall(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = total - strike;
        
        String result = null;   
        
        if(total == 0){
            result = "낫싱";
        }else if(ball != 0 && strike == 0){
        	result = ball + "볼";
        }else if(strike != 0 && ball == 0){
        	result = strike + "스트라이크";
        }else {
        	result = ball + "볼 " + strike + "스트라이크";
        }
        return result;
    }
}
