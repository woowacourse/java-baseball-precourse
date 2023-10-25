package util;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
	
		public List<Integer> userNumber() {
	        System.out.print("숫자를 입력해주세요 : ");
	        String input = Console.readLine();
	        // 예외 처리 메서드 만들기....
	        
	        List<Integer> userNum = new ArrayList<>();
			for(String number: input.split("")){
				userNum.add(Integer.parseInt(number));
			}
	        return userNum;
	    }

	public boolean replay(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = Console.readLine();
		char answer = input.charAt(0);
        if(answer == '1'){
            return true;
        }
        return false;
    }
	
}
