package baseball;

// 0 ~ 9까지의 숫자가 있다.
// 그 중 임의로 숫자 3개를 뽑는다.

import java.util.Random;

public class Computer {

    int[] randomNum;

    public Computer() {
        randomNum = new int[3];
        Raffle();
    }

    public void Raffle() {

        Random random = new Random();

        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = random.nextInt(10); // 0 ~ 9
        }
    }

    public int[] getRandomNum() {
        return randomNum;
    }
}