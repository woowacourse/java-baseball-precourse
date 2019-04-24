/**
 * Game 진행에 필요한 연산을 하는 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public class Processor {
	
	/**
	 * strike, ball 수를 세는 메소드
	 * 
	 * @param mergedArr
	 * @return	int[]
	 */
	static int [] cntBallStrike(int[] mergedArr){
		int strike = 0;
		int ball = 0;
		
		for(int val : mergedArr) {
	    	if(val == 1) {
	    		strike++;
	    	}
	    	else if(val == 2) {
	    		ball++;
	    	}
	    }
		int [] result = {strike, ball};
		return result;
	}

	/**
	 * 3스트라이크 판정 메소드
	 * 
	 * @param int
	 * @return	boolean
	 */
	public static boolean isThreeStrike(int strike) {
		if(strike == 3) return true;
		return false;
	}
	
	/**
	 * 결과를 출력하는 메소드
	 * 
	 * @param strike, ball
	 */
	public static void showResult(int strike, int ball) {
		if(strike != 0) {
	    	System.out.print(strike + Msgs.Strike.getMsg());
	    }
	    if(ball != 0) {
	    	System.out.print(ball + Msgs.Ball.getMsg());
	    }
	    System.out.println();
	    
	    if(strike == 3) {
			System.out.println(Msgs.ThreeStrike.getMsg());
	    }	
	}
}
