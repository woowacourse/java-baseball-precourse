package baseball;

import java.util.Arrays;

public class Hints {
    int Strike(int answer, int userAnswer) {
        int correct = 0;
        for (int i=1; i<101; i=i*10) {
            if (answer%(i*10)/i == userAnswer%(i*10)/i) correct++;
        }
        return correct;
    }

    int ball(int Strike, int answer, int userAnswer) {
        int correct = 0;
        Integer[] arr = new Integer[]{answer%10,answer%100/10,answer/100};
        for (int i=1; i<101; i=i*10) {
            if (Arrays.asList(arr).contains(userAnswer % (i * 10) / i)) correct++;
        }
        return correct-Strike;
    }
}
