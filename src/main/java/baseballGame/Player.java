/*
 *  @Player.java
 *
 *  1부터 9까지의 3자리 숫자를 입력한다.
 *
 *  @Version: 0.2
 *
 *  @Date: 2019.11.28
 *
 *  @Author: pandahun
 */

package baseballGame;

import java.util.Scanner;

class Player {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int BASEBALL_LENGTH = 3;

    private String number = "";

    void requestNumber() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해 주세요: ");
            number = sc.next();

            if (isInLength() && isNumber() && isRepetition()) {
                break;
            } else {
                System.out.println("값을 재 입력해 주세요");
            }
        }
    }

    private boolean isInLength() {
        return number.length() == BASEBALL_LENGTH;
    }

    private boolean isNumber() {
        String pattern = "^[1-9]*$";
        if (number.matches(pattern)) {
            return true;
        }
        return false;
    }

    private boolean isRepetition() {
        boolean status = true;
        boolean[] isIn = new boolean[10];
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            int current = number.charAt(i)- '0';
            isIn[current] = true;
        }
        int count = 0;
        for(int i = MINIMUM_NUMBER; i<=MAXIMUM_NUMBER;i++){
            count++;
        }
        if(count!=3){
            status = false;
        }
        return status;
    }

    public String getNumber() {
        return number;
    }
}
