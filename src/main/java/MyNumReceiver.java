import java.util.Scanner;

public class MyNumReceiver {
	static int receive(){
		Scanner sc = new Scanner(System.in);

    	System.out.print(Msgs.MyNumReceive.getMsg());
	    int myNum = sc.nextInt();
	    
	    return myNum; 
	}
}
