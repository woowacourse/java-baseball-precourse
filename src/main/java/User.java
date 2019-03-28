package src.main.java;

import java.util.Scanner;

/**
 * 사용자의 입력을 받음
 * 받은 입력이 올바른지 검증
 * 정답과 비교하기 위해 자릿수로 분리
 * @author 강연욱
 *
 */
public class User {
	
    /**
     * 3자리 수를 각각의 자릿수에 따라 분리한다
     * ex) 123 -> 1, 2, 3
     * @param num 	3자리 수
     * @return res 	자리 수에 따른 분리된 수
     */
    public static int[] calSplitNum(int num) {
		
        int[] res = new int[3];
		
        res[0] = num / 100;
        num = num % 100;
		
        res[1] = num / 10;
        num = num % 10;
		
        res[2] = num;
		
        return res;
    }
    
    // 3자리가 아닐 경우
    public static boolean isLength(String input) {
        return input.length() == 3;
    }
	
    // 입력이 숫자인지
    public static boolean isNumber(String input) {
        boolean isNum;
        isNum = true;
        
        try {
            Double.parseDouble(input);
        } catch (Exception e){
            System.out.println(e);
            isNum = false;
        }
		
        return isNum;
    }
	
    // 서로 다른 수인지
    public static boolean isDuplicate(String input) {
	    return (input.charAt(0) != input.charAt(1)
	        && (input.charAt(0) != input.charAt(2))
	        && (input.charAt(1) != input.charAt(2))); 
    }
	
    /**
     * String input이 valid한지 검사한다
     * 1. 3자리인지
     * 2. 숫자인지
     * 3. 서로 다른 수인지
     * @param input
     * @return
     */
    public static boolean isValidInput(String input) {
        return isLength(input) 
            && isNumber(input) 
            && isDuplicate(input);
    }
    
    /**
     * 게임 플레이어는 3개의 숫자를 입력한다
     * @return
     */
    public static int[] input() {
		
        String str;
        int inputNum;
        int[] splitNum = new int[3];
        
        // 입력
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            str = sc.nextLine();
            
            // 서로 다른 3자리 수인지 판별
            if (isValidInput(str)) {
                break;
            }
			
            // 아닐 경우 다시 입력
            System.out.println("서로 다른 3자리의 수를 입력하세요");
        }
        inputNum = Integer.parseInt(str);
		
        // 입력한 숫자를 분리
        splitNum = calSplitNum(inputNum);
		 
        return splitNum;
    }
}
