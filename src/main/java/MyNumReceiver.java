import java.util.Scanner;

public class MyNumReceiver {
	static int receive(){
		Scanner sc = new Scanner(System.in);

    	System.out.print("세자리 수를 입력하세요.");
	    int myNum = sc.nextInt();
	    
	    return myNum; 
	}
}
