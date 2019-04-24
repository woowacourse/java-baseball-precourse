import java.util.InputMismatchException;
import java.util.Scanner;

public class GameModeReceiver {
	static int receive(){
	    int gameMode = 0;
		Scanner sc = new Scanner(System.in);

    	System.out.println(Msgs.GameModeReceive.getMsg());
    	try {
    		gameMode = sc.nextInt();
    	} catch(InputMismatchException e) {
    		System.out.println(Msgs.InputTypeErr.getMsg());
    		receive();
    	}
    	if(!ValidChecker.isValidGameMode(gameMode)){
    		System.out.println(Msgs.InputWrongErr.getMsg());
     		receive();
    	};
	    return gameMode; 
	}
}
