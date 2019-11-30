/**
 * 클래스 이름      RandomNumber
 * 버전 정보        1.0
 * 날짜            2019.11.28
 * 저작권          YebinK
 */

import java.util.Random;

public class RandomNumber {

    private int [] number = new int[3];
    private int numberIndex = 0;

    /* 1부터 9까지 서로 다른 3자리 수 뽑기 */
    public int [] setNumber() {

        Random r = new Random();

        while (numberIndex < 3) {
            int newNumber = r.nextInt(9) + 1;
            if (!duplicated(newNumber)) {
                number[numberIndex] = newNumber;
                numberIndex++;
            }
        }

        System.out.print("answer is " + number[0]+number[1]+number[2] +'\n');
        return number;
    }

    /* 새로 뽑은 수가 이전 수들과 중복되는지 확인 */
    public boolean duplicated(int newNumber) {
        for (int i = 0 ; i < numberIndex ; i++) {
            if (number[i] == newNumber) return true;
        } return false;
    }
}