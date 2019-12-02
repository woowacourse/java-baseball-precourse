import java.util.Random;

/**
 * 클래스 이름      RandomNumber
 * 버전 정보        1.0
 * 날짜            2019.11.28
 * 저작권          YebinK
 */

public class RandomNumber {
    /* 랜덤으로 1부터 9까지 서로 다른 3자리 수를 뽑는 클래스 */


    /** 정답 숫자를 저장하는 변수 */
    private int [] number = new int[3];

    /** 서로 다른 숫자인지 확인하기 위해 number 변수의 index를 기록하는 변수 */
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
        return number;
    }

    /* 새로 뽑은 수가 이전 수들과 중복되는지 확인 */
    public boolean duplicated(int newNumber) {
        for (int i = 0 ; i < numberIndex ; i++) {
            if (number[i] == newNumber) return true;
        } return false;
    }
}