package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Random {

    public static String random_Num(){
        int[] computerNumber = new int[3];
        int i = 0;
        do {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (isOverlap(computerNumber, newNumber)) {
                continue;
            }
            computerNumber[i] = newNumber;
            i = i + 1;
        } while (i < 3);

        
        return Arrays.toString(computerNumber).replaceAll("[^0-9]", "");
    }

    private static boolean isOverlap(int[] computerNumber, int newNumber) {
        return Arrays.stream(computerNumber).anyMatch(k -> k == newNumber);
    }
}
