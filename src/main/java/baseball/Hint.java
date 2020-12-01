package baseball;

import java.util.List;

public class Hint {
 
    private static int[] result = new int[2];        

    
    // 플레이어가 입력한 숫자와 정답을 비교해서 볼과 스트라이크를 카운트한다.
    public static int[] grading(List<Integer> player, List<Integer> answer) {
    	
    	int ball = 0;
        int strike = 0;
        
        for (int i=0; i<3; i++) {
            if (player.get(i).equals(answer.get(i))) {
                strike++;
            }
            else if (answer.contains(player.get(i))) {
                ball++;
            }
        }
        
        result[0] = ball;
        result[1] = strike;
        return result;
    }
}
