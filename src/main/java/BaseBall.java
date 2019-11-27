/*
 * BaseBall.java
 *
 * version 1.0
 *
 * 20191127
 *
 * copyright by jiwonSong
 *
 */

import java.util.Scanner;

public class BaseBall {

    static final int INPUT_SIZE = 3;
    static final int MAX_NUMBER = 9;
    private int answer;
    private int userInput;
    private int strikeCount=0;
    private int ballCount=0;
    private boolean isNothing = false;

    private int makeRandomNumber(int maxNumber) {
        int randomNumber1 = 0;
        int randomNumber2 = 0;
        int randomNumber3 = 0;
        int randomNumber = 0;
        
        randomNumber1 = (int) (Math.random() * maxNumber + 1);

        while (true) {
            randomNumber2 = (int) (Math.random() * maxNumber + 1);
            if (randomNumber1!=randomNumber2) {
                break;
            }
        }

        while (true) {
            randomNumber3 = (int) (Math.random() * maxNumber + 1);
            if ((randomNumber1 != randomNumber3) && (randomNumber2 != randomNumber3)) {
                break;
            }
        }

        randomNumber = 100 * randomNumber1 + 10 * randomNumber2 + randomNumber3;
        return randomNumber;
    }

}
