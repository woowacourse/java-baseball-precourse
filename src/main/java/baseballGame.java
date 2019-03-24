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
	    }
	}
}
