import java.util.Scanner;

/*
 * 야구 경기를 진행하는 클래스
 * 
 * @version			1.00 2019년 3월 24일
 * @author 			Wonseok Choi
 */
public class BaseballGame {
	
		void init(){
	    
	    int gameMode = 1;							
    	int comNum = ComNumReceiver.receive();				
    	System.out.println(comNum);

	    while(gameMode == 1) {
		    int myNum = MyNumReceiver.receive();				
		    
		    int [] comNumArr = Utils.numsToArr(comNum);		
		    int [] myNumArr = Utils.numsToArr(myNum);
		    int [] mergedArr = Utils.mergeArrs(comNumArr, myNumArr);
		    
		    int [] middleResult = Processor.cntBallStrike(mergedArr);	
		
		    int strike = middleResult[0];
		    int ball = middleResult[1];
		    
		    Processor.showResult(strike,ball);
		    if(Processor.isThreeStrike(strike)) {
			    gameMode = GameModeReceiver.receive();
			    comNum = ComNumReceiver.receive();
		    }
	    }
	}
}
