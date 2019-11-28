/*
 *  @Player.java
 *
 *  1부터 9까지의 3자리 숫자를 입력한다.
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.11.27
 *
 *  @Author: pandahun
 */

package baseballGame;

import java.util.Scanner;

class Player {

    private static final int BASEBALL_LENGTH = 3;

    private String number ="";

    void requestNumber(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("숫자를 입력해 주세요: ");
            number = sc.next();

            if(isInLength() && isNumber() && isRepetition()){
                break;
            }
            else{
                System.out.println("값을 재 입력해 주세요");
            }
        }
    }

    private boolean isInLength(){
        return number.length()==BASEBALL_LENGTH;
    }

    private boolean isNumber(){
        String pattern = "^[1-9]*$";
        if(number.matches(pattern)){
            return true;
        }
        return false;
    }

    private boolean isRepetition(){
        boolean status  = true;
        for(int i = 0 ; i <BASEBALL_LENGTH; i++){
            char current = number.charAt(i);
            String temp = number.replace(String.valueOf(current), " ");

            if(temp.contains(String.valueOf(current))){
                status = false;
                break;
            }
        }
        return status;
    }

    public String getNumber(){
        return number;
    }
}
