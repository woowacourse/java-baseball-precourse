package baseball;

import java.util.Scanner;

public class Player {

    private static Scanner scanner = new Scanner(System.in);

    public String getNumber(){
        String result = "";

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.nextLine();

            // 중복 X, 1~9 이외 숫자 X
            if(checkNumber(inputNumber)){
                result = inputNumber;
                break;
            }
            // 예외
            else{
                throw new IllegalArgumentException("input error");
            }
        }

        return result;
    }

    public int getRestartOrEnd(){
        String input = scanner.nextLine();

        if(input.equals("1") || input.equals("2")){
            return Integer.parseInt(input);
        }
        else{
            throw new IllegalArgumentException("input error");
        }
    }

    private static boolean checkNumber(String inputNumber){
        //길이 체크 && 숫자인지 확인 && 중복 체크
        if(checkLen(inputNumber) || isNumber(inputNumber) || checkDuplication(inputNumber)){
            return false;
        }
        else {
            return true;
        }
    }

    private static boolean checkLen(String inputNumber){
        if(inputNumber.length() != Constants.NUMBER_LEN){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean isNumber(String inputNumber){
        for(int i=0;i<inputNumber.length();i++) {
            char c = inputNumber.charAt(i);
            if (c < '1' || c > '9') {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDuplication(String inputNumber){
        boolean[] numbers = new boolean[Constants.MAX_NUMBER+1];

        for(int i=0;i<inputNumber.length();i++){
            int num = inputNumber.charAt(i) - '0';
            if(!numbers[num]){
                numbers[num] = true;
            }
            else{
                return true;
            }
        }

        return false;
    }
}
