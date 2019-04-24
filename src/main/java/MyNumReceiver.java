import java.util.InputMismatchException;
import java.util.Scanner;

public class MyNumReceiver {
	static int myNum = 0;
	
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
