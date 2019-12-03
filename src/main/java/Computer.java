/**
 * Computer.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    public List<Integer> pickRandomNumbers(int digitNumber) {
        boolean[] index = new boolean[10];
        List<Integer> newNumber = new ArrayList<>();
        int temp, i = 0;
        while (i < digitNumber) {
            temp = new Random().nextInt(9) + 1;
            if (index[temp] == true) {
                continue;
            }
            index[temp] = true;
            newNumber.add(temp);
            i++;
        }
        return newNumber;
    }
}
