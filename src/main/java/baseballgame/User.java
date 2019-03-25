/*
 * @(#)User.java        0.2 2019/03/26
 *
 *
 */

package baseballgame;

import java.util.Scanner;

/**
 * 기능 목록 3 - 사용자가 3자리 숫자를 입력하는 기능을 위한 클래스입니다.
 *
 * @version         0.2 2019년 3월 26일
 * @author          반선호
 */
class User {

    /** 사용자가 입력한 각 자리의 수가 1이상인지 확인을 위한 상수*/
    private static final char START_WORD = '1';

    /** 사용자가 입력한 각 자리의 수가 9이하인지 확인을 위한 상수*/
    private static final char END_WORD = '9';

    /** 숫자의 최대 길이 상수 */
    private static final int BALL_LEN = 3;

    /** 입력받은 숫자를 담을 문자열 */
    String number;


    /**
     * 사용자에게 입력을 요청하는 메소드이다.
     */
    void requestNumber(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("중복되지 않는 3자리의 수를 입력해주세요 : ");
            number = sc.next();

            if(checkLen() && checkNum() && checkDuplicate()){

                /* 길이가 3, 모두 숫자, 중복이 아님을 모두 만족한다면 종료한다.*/
                break;
            }
            else {
                System.out.println("[ERROR]입력 값이 잘못 되었습니다. 다시 입력해주세요.");
            }
        }

    }

    /**
     * 사용자가 입력한 문자열의 길이를 확인하는 메소드이다
     * @return 길이가 3이라면 true를 return한다.
     */
    private boolean checkLen(){
        return (number.length() == BALL_LEN);
    }

    /**
     * 사용자가 입력한 3자리의 문자가 1 ~ 9사이의 수로 이루어져 있는지 확인한다.
     * @return 만약 1 ~ 9로만 이루어져 있다면 true를 return한다.
     */
    private boolean checkNum(){
        boolean status = true;

        for(int i = 0; i < number.length(); i++){
            if((number.charAt(i) < START_WORD) || (number.charAt(i) > END_WORD) ){
                status = false;
                break;
            }
        }

        return status;
    }

    /**
     * 사용자가 입력한 3자리의 문자에 중복이 있는지 확인한다.
     * @return 각각의 문자에 중복이 없다면 true를 return한다.
     */
    private boolean checkDuplicate(){
        boolean status = true;
        String temp;                    //중복 검사를 위한 임시 문자열

        for(int i = 0; i < number.length(); i++){
            temp = number.replaceFirst(String.valueOf(number.charAt(i)),"");
            if(temp.contains(String.valueOf(number.charAt(i)))){
                status = false;
                break;
            }
        }

        return status;
    }
}
