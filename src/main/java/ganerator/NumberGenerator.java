package ganerator;

import utils.RandomUtils;

/** 3자리 번호를 생성하는 클래스 */
public class NumberGenerator {
    private static boolean[] numFlag = new boolean[10]; //중복체크하는 배열
    private static int[] newNumber = new int[3]; //세자리 수

    /**
     * flag 배열을 false로 초기화해서 반환하는 메소드
     * @return numFlag
     */
    public static boolean[] initNumFlag() {
        for (int i = 0; i < 10; i++) {
            numFlag[i] = false;
        }

        return numFlag;
    }

    /**
     * 1~9까지의 임의의 수 3개를 정하는 메소드
     * @return newNumber
     */
    public static int[] generatorNewNumber() {
        numFlag = initNumFlag();

        int count = 0;
        while (count < 3) {
            int randomNumber = RandomUtils.nextInt(1, 9); //1~9사이의 랜덤값
            if(numFlag[randomNumber]) continue; //이미 사용되었으면 패스
            numFlag[randomNumber] = true; //방문체크
            newNumber[count++] = randomNumber;
        }

        return newNumber;
    }
}
