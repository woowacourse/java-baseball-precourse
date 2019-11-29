/*
 *  @Player.java
 *
 *  1부터 9까지의 3자리 숫자를 입력한다.
 *
 *  @Version: 0.3
 *
 *  @Date: 2019.11.29
 *
 *  @Author: pandahun
 */

package baseballGame;

import java.util.Scanner;
import static baseballGame.BaseballGame.BASEBALL_LENGTH;

class Player {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    private String number = "";

    void requestNumber() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해 주세요: ");
            number = sc.next();

            if (!isInLength() || !isNumber() || !isRepetition()) {
                System.out.println("값을 재 입력해 주세요");
                continue;
            }
            break;
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
            if(isIn[i])
                count++;
        }
        if(count!=BASEBALL_LENGTH){
            status = false;
        }
        return status;
    }

    public String getNumber() {
        return number;
    }
}
