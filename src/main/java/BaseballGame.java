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
    	
	    while(gameMode == 1) {
	    	
		    int myNum = MyNumReceiver.receive();				
		    
		    int [] comNumArr = Utils.numsToArr(comNum);		
		    int [] myNumArr = Utils.numsToArr(myNum);
		    int [] mergedArr = Utils.mergeArrs(comNumArr, myNumArr);
		     
		    int [] result = ResultProcessor.process(mergedArr);	
		
		    int strike = 
		    /* ����� ��� */
		    if(strike != 0) {
		    	System.out.print(strike + "��Ʈ����ũ ");
		    }
		    if(ball != 0) {
		    	System.out.print(ball + "��");
		    }
		    System.out.println();
		    
		    /* 3��Ʈ����ũ �� ���Ӹ�� ����*/
		    if(strike == 3) {
		    	System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ��������");
		    	System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		    	gameMode = sc.nextInt();
		    	comNum = getComNum();		// ���ο� ������ ���ڸ���
		    }
	    }
	    sc.close();
	}
}
