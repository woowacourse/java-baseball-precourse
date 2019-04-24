import java.util.Scanner;

public class GameModeReceiver {
	static int receive(){
		Scanner sc = new Scanner(System.in);

		System.out.println(Msgs.ThreeStrike.getMsg());
    	System.out.print(Msgs.GameModeReceive.getMsg());
	    int myNum = sc.nextInt();
	    
	    return myNum; 
	}
}
