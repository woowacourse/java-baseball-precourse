package baseball;

import java.util.ArrayList;
import java.util.List;
import utils.RandomUtils;

public class Answer {
    private static final int min = 1;
    private static final int max = 9;

    private static List<Integer> ans = new ArrayList<>();
    
    // 숫자 야구의 정답 생성
    public static List<Integer> makeAnswer(boolean flag) {
    	
    	if (flag) {
    		resetAns();
    	}
    	
    	// 중복값을 확인하며 추가한다.
        int randomNumber = RandomUtils.nextInt(min, max);
        if (!ans.contains(randomNumber)) {
            ans.add(randomNumber);
        }
        if (ans.size() == 3) {
            return ans;
        }
        
        return makeAnswer(false);
    }
    
    
    // 게임을 재시작했을 때 ans를 초기화한다.
    public static void resetAns() {
    	ans = new ArrayList<>();
    }
}