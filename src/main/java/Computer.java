/**
 * Computer.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

import java.util.Random;

public class Computer {
    public int[] pickRandomNumber(int digitNumber) {
        Random random = new Random();
        int[] dictionary = new int[10];
        int[] generatedNumber = new int[digitNumber];
        int temp, i = 0;
        while (i < digitNumber) {
            temp = random.nextInt(9) + 1;
            generatedNumber[i] = temp;
            if (dictionary[temp] == 1) {
                continue;
            }
            dictionary[temp] = 1;
            i++;
        }
        return generatedNumber;
    }
}
