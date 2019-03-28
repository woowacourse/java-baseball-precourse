package src.main.java;

/**
 * Baseball Game play
 * 게임 실행 및 종료
 * 게임 규칙 : README.md 참조
 * @author 강연욱
 * @version 2019.03.24
 */

public class Baseball {
	
    // 게임 시작 intro
    public void intro() {
        System.out.println("게임을 시작합니다!");
        System.out.println("숫자 생성 중...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Baseball 게임 진행
     */
    public void game() {
        
        boolean isAnswer;
        int[] answer = new int[3];
        int[] inputNum = new int[3];
        int[] ballCnt = new int[2];
        
        intro();
        
        Computer.createNum(answer);		// 정답 생성
		
        do {
        	inputNum = User.input();	// 사용자 입력
            
            //strike, ball 개수 세기
            ballCnt[0] = 0;
            ballCnt[1] = 0;
            Computer.compareNum(answer, inputNum, ballCnt);
            
            isAnswer = Computer.checkAnswer(ballCnt);		// 정답 확인
            
        } while (!isAnswer);
        
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
