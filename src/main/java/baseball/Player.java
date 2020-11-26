/*
 * @(#)Player.java
 *
 */

package baseball;

import java.util.Scanner;

public class Player {
    boolean[] checkNumberDuplicated = new boolean[Constants.MAX_RANGE];
    int[] numbers;

    public Player(){

    }

    public int[] getNumbers() { return numbers; }

    /**
     * 플레이어에게 세 자리 수를 입력 받는 메소드
     */
    public void inputThreeNumbers(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
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

    /**
     * String을 Integer Array로 변환하는 메소드
     *
     * @param string
     */
    private void parseStringToIntegerArray(String string){
        numbers = new int[Constants.MAX_LEN];
        for (int i = 0; i < string.length(); i++) {
            numbers[i] = Character.getNumericValue(string.charAt(i));
        }
    }

    /**
     * 입력받은 String의 길이가 최대 허용 길이인 3과 일치하는지 검증하는 메소드
     *
     * @param string
     * @return 길이가 3이라면 True를 리턴하고, 아니면 False를 리턴한다.
     */
    private boolean isEqualsToMaxLength(String string){
        return (string.length() == Constants.MAX_LEN);
    }

    /**
     * 입력받은 String에 중복된 수가 존재하는지 검증하는 메소드
     *
     * @param string
     * @return 중복된 수가 존재하지 않는다면 True를 리턴하고, 아니면 False를 리턴한다.
     */
    private boolean isDuplicated(String string){
        boolean result = true;
        String temp;

        for (int i = 0; i < string.length(); i++) {
            temp = string.replaceFirst(String.valueOf(string.charAt(i)),"");
            if(temp.contains(String.valueOf(string.charAt(i)))){
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * 입력받은 String이 1~9사이의 범위에 존재하는 수들로 이루어져있는지 검증하는 클래스
     *
     * @param string
     * @return 범위에 속한다면 True를 리턴하고, 아니면 False를 리턴한다.
     */
    private boolean isInRange(String string){
        boolean result = true;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '0'){
                result = false;
            }
        }

        return result;
    }

    /**
     * 입력받은 String이 모두 수로 이루어져있는지 검증하는 메소드
     *
     * @param string
     * @return 모두 수로 이루어져있다면 True를 리턴하고, 아니면 False를 리턴한다.
     */
    private boolean isDigit(String string){
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
