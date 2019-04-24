import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 사용자의 숫자를 입력 받는 클래스
 * 
 * @version			1.00 2019년 3월 24일
 * @author 			Wonseok Choi
 */
public class MyNumReceiver {
	static int myNum = 0;
	
	/**
	 * 사용자의 숫자를 입력받는 메소드
	 * 
	 * @return		myNum
	 */
	static int receive(){
		Scanner sc = new Scanner(System.in);
		
    	System.out.println(Msgs.MyNumReceive.getMsg());
    	try {
    		myNum = sc.nextInt();
    		if(!ValidChecker.isValidMyNum(myNum)){
        		System.out.println(Msgs.InputWrongErr.getMsg());
        		receive();
        	};
    	} catch(InputMismatchException e) {
    		System.out.println(Msgs.InputTypeErr.getMsg());
    		receive();
    	}

	    return myNum; 
	}	
}
