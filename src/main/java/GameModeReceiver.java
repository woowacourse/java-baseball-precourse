import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 게임 모드를 입력 받는 클래스
 * 
 * @version			1.00 2019년 3월 24일
 * @author 			Wonseok Choi
 */
public class GameModeReceiver {
	
	/**
	 * 게임모드를 입력받는 메소드
	 * 
	 * @return		gameMode
	 */
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
