package src.main.java;

import java.util.ArrayList;

/**
 * 정답 숫자를 생성하고
 * 사용자 입력을 정답과 비교하는 클래스
 * @author 강연욱
 *
 */
public class Computer {
    
    /**
     * strike와 ball의 개수를 통해
     * 정답인지 판별
     * @param ballCnt	[0] : strike, [1] : ball
     * @return
     */
    public static boolean checkAnswer(int[] ballCnt) {
        
        if (ballCnt[0] == 3){									// 정답
            System.out.println("3 스트라이크");
            return true;
        } else if((ballCnt[0] == 0) && (ballCnt[1] == 0)) {     // 낫싱
            System.out.println("낫싱");
        } else if(ballCnt[1] == 0) {                            // strike만 있을 경우
            System.out.println(ballCnt[0] + " 스트라이크");
        } else if(ballCnt[0] == 0) {                            // ball만 있을 경우
            System.out.println(ballCnt[1] + " 볼");
        } else {
            System.out.println(ballCnt[0] + " 스트라이크 " + ballCnt[1] + " 볼 ");
        }
        
        return false;
    }
    
    // strike 여부
    public static boolean isStrike(int a, int b) {
        return a == b;
    }

    // ball 여부
    public static boolean isBall(int[] answer, int[] input, int digit) {
        
    	boolean okBall;
        okBall = false;
        
        for (int i = 0; i < 3; i++) {
			
            // strike에서 이미 판별
            if (i == digit) {
                continue;
            }
            
            // ball일 경우
            if (input[digit] == answer[i]) {
            	okBall = !okBall;
                break;
            }
        }
        
        return okBall;
    }

    /**
     * strike, ball 개수 확인
     * @param answer	정답
     * @param input 	사용자 입력
     * @param ballCnt	[0] : strike, [1] : ball 
     */
    public static void compareNum(int[] answer, int[] input, int[] ballCnt) {

        for (int i = 0; i < 3; i++) {
            if (isStrike(answer[i], input[i])) {
                ballCnt[0]++;
            } else if (isBall(answer, input, i)) {
                ballCnt[1]++;
            }
        }
    }

    /**
     * 1부터 9까지 랜덤한 숫자 3개 생성
     * 생성된 숫자는 서로 다른 수 (중복 x)
     * @param randNum
     */
    public static void createNum(int[] randNum) {
        
        int cnt, temp;
        ArrayList numList = new ArrayList();

        cnt = 0;
        while (cnt <= 2) {
            
        	// 1~9 숫자 생성
            temp = (int) (Math.random() * 9) + 1;
			
            // 중복 판별
            if (!numList.contains(temp)) {
            	
            	// 생성된 수 저장
                randNum[cnt] = temp;
                numList.add(temp);
                cnt++;
            }
        }
    }
}
