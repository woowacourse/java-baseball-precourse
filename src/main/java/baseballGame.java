import java.util.Scanner;

/*
 * 숫자 야구 게임을 구현한 클래스
 * 
 * @version			1.00 2019년 3월 24일
 * @author 			Wonseok Choi
 */
public class baseballGame {

	/*
	 * 임의의 값 3개를 정해 3자리 수로 만들어 주는 메소드
	 * 
	 * @return 			임의의 세자리수 
	 */
	public static int getComNum() {
		int first = (int)(Math.random()*9 + 1);		// 100의 자리수
    	int second = (int)(Math.random()*9 + 1);	// 10의 자리수
    	int third = (int)(Math.random()*9 + 1);		// 1의 자리수
    	
    	/* 자리수끼리 중복되지 않도록 한다*/
    	while((second == first)) {
    		second = (int)(Math.random()*9 + 1);
    	}
    	while((third == first) 
	    	|| (third == second)) {
    		third = (int)(Math.random()*9 + 1);
	    }
    	
    	return (first*100 + second*10 + third);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    
	    int gameMode = 1;							// 게임 종료 여부
    	int comNum = getComNum();					// 임의의 세자리 수
    	
	    while(gameMode == 1) {
	    	
	    	System.out.print("숫자를 입력해주세요 : ");
		    int myNum = sc.nextInt();				// 사용자의 세자리 수
		    
		    int [] comNumArr = new int[3];			// comNum의 각 자리수 저장
		    int [] myNumArr = new int[3];			// myNum의 각 자리수 저장
		    int [] tempArr = new int[10];			// 판정을 위한 배열
		    
		    int comNumTemp = comNum;				// comNum 임시 저장
		    int myNumTemp = myNum;					// myNum 임시 저장
		    
		    /* 세자리 수를 자리수 순으로 배열에 저장 */
		    for(int i = 0; i < 3; i++) {
		        comNumArr[i] = comNumTemp % 10;
		        myNumArr[i] = myNumTemp % 10;
		        
		        comNumTemp = comNumTemp / 10;
		        myNumTemp = myNumTemp / 10;
		    }
		    
		    /* 
		     * 판정 배열에 comNum 위치 값 입력
		     * 
		     * 예)
		     * comNum = 234 인 경우
		     * tempArr[2] = (0+1)*-1 (2의 위치가 0번째)
		     * tempArr[3] = (1+1)*-1 (3의 위치가 1번째)
		     * tempArr[4] = (2+1)*-1 (4의 위치가 2번째)
		     * 
		     * */
		    for(int i = 0; i < 3; i++) {
		    	int comNumVal = comNumArr[i];
		    	tempArr[comNumVal] = (i+1)*-1;
		    }
		    
		    /* 
		     * myNum 위치 값을 판정 배열과 비교
		     * 
		     * 예)
		     * myNum = 432 인 경우
		     * tempArr[2] != (2+1)*-1 (2의 위치가 2번째) 
		     * tempArr[3] == (1+1)*-1 (3의 위치가 1번째)
		     * tempArr[4] != (0+1)*-1 (4의 위치가 0번째) 
		     * 
		     * */
		    for(int i = 0; i < 3; i++) {
		    	int myNumVal = myNumArr[i];
		    	
		    	/* 스트라이크인 경우 (값, 자리수 일치) */
		    	if((tempArr[myNumVal] != 0) 
		    		&& (tempArr[myNumVal] == (i+1)*-1)) {
		    		tempArr[myNumVal] = 1; 
		    	}
		    	/* 볼인 경우 (값 일치, 자리수 불일치) */
		    	else if((tempArr[myNumVal] != 0) 
		    		&& (tempArr[myNumVal] != (i+1)*-1)) {
		    		tempArr[myNumVal] = 2;
		    	}
		    	/* 나머지 경우 (값, 자리수 불일치) */
		    	else {
		    		tempArr[myNumVal] = 3;
		    	}
		    }
		    
		    
		    int strike = 0;				// 스트라이크 수
		    int ball = 0;				// 볼 수
		    
		    /* 스트라이크와 볼의 수를 센다 */
		    for(int i = 0; i < 10; i++) {
		    	if(tempArr[i] == 1) {
		    		strike++;
		    	}
		    	else if(tempArr[i] == 2) {
		    		ball++;
		    	}
		    }
		    
		    /* 결과물 출력 */
		    if(strike != 0) {
		    	System.out.print(strike + "스트라이크 ");
		    }
		    if(ball != 0) {
		    	System.out.print(ball + "볼");
		    }
		    System.out.println();
		    
		    /* 3스트라이크 시 게임모드 선택*/
		    if(strike == 3) {
		    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		    	gameMode = sc.nextInt();
		    	comNum = getComNum();		// 새로운 임의의 세자리수
		    }
	    }
	    sc.close();
	}
}
