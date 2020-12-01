package baseball;

import utils.RandomUtils;

public class RandomNumber {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    //1에서 9까지 서로 다른 임의의 수 3개를 생성하는 함수
    public static String generateNumbers(int numberLength) {
        String returnNumber = "";
        while (returnNumber.length() < numberLength) {
            //숫자를 생성해서 String으로 형변환 한다
            String tempNumber = Integer.toString(RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER));
            if (!returnNumber.contains(tempNumber)) {
                returnNumber += tempNumber;
            }
        }
        return returnNumber;
    }
}