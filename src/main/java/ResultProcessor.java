
public class ResultProcessor {
	static int [] process(int[] mergedArr){
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
}
