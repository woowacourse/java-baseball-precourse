package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Player {
	
	private static int playerInput;
	private static final String errorMessage = "3자리의 수만 입력할 수 있습니다.";
	
	
	// 유효한 플레이어 입력을 받는다.
    public static int getPlayerInput() {
    	Scanner scanner = new Scanner(System.in);
    	
    	if (scanner.hasNextInt()) {
    		playerInput = scanner.nextInt();
    	} else {
    		System.out.println(errorMessage);
    		getPlayerInput();
    	}
    	
    	
    	try {
    		validateInput(playerInput);
    	} catch (IllegalArgumentException e) {
    		System.out.println(e.toString());
    		getPlayerInput();
    	}
    	
        return playerInput;
    }
    
    
    // int를 List로 바꾼다.
    public static List<Integer> numberToArray(int num) {
        String temp = Integer.toString(num);

        List<Integer> userNumber = new ArrayList<>();
        for (int i=0; i<3; i++) {
            userNumber.add(temp.charAt(i) - '0');
        }

        return userNumber;
    }
    
    
    // 자릿수가 맞는지 검사한다.
    public static boolean validateInput(int input) throws IllegalArgumentException {
        if ((int)(Math.log10(input))+1 != 3) {
        	throw new IllegalArgumentException(errorMessage);
        }
        
    	return true;
    }

}