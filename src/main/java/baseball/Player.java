package baseball;


import java.util.Scanner;

public class Player {
    boolean[] checkNumberDuplicated = new boolean[Constants.MAX_RANGE];
    int[] numbers;

    public void Player(){

    }

    public void inputThreeNumbers(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            String input = sc.nextLine();
            if(!isDigit(input)
                    || !isEqualsToMaxLength(input)
                    || !isDuplicated(input)
                    || !isInRange(input)){
                throw new IllegalArgumentException("1~9 사이의 수로 이루어진 서로 다른 세 자리 수만 입력 가능합니다.");
            } else {
                parseStringToIntegerArray(input);
                break;
            }
        }
    }

    public int[] getNumbers() { return numbers; }

    private void parseStringToIntegerArray(String string){
        numbers = new int[Constants.MAX_LEN];
        for(int i = 0; i < string.length(); i++){
            numbers[i] = Character.getNumericValue(string.charAt(i));
        }
    }

    private boolean isEqualsToMaxLength(String string){
        return (string.length() == Constants.MAX_LEN);
    }

    private boolean isDuplicated(String string){
        boolean result = true;
        String temp;

        for(int i = 0; i < string.length(); i++){
            temp = string.replaceFirst(String.valueOf(string.charAt(i)),"");
            if(temp.contains(String.valueOf(string.charAt(i)))){
                result = false;
                break;
            }
        }

        return result;
    }


    private boolean isInRange(String string){
        boolean result = true;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '0'){
                result = false;
            }
        }

        return result;
    }

    private boolean isDigit(String string){
        try{
            Integer.parseInt(string);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
