package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class NumberGenerator {

    /*
    * RandomUtils를 이용해 랜덤 숫자를 만드는 클래스
    * */

    private static final ArrayList<Integer> randomNumbersList = new ArrayList<>();
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    /*
    * numbers 길이가 3이고 중복되지 않는 숫자들의 ArrayList를 리턴하는 메서드
    * */
    public static ArrayList<Integer> getRandomNumberNotRepeat() {
        randomNumbersList.clear();
        while (randomNumbersList.size() < NUMBER_LENGTH) {
            int random = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);

            checkIntegerInList(random);
        }

        return randomNumbersList;
    }

    /*
    * 숫자가 중복되지 않도록 랜덤으로 뽑힌 숫자가 이미 numbers에 포함되어있는지 확인하는 메서드
    * */
    public static void checkIntegerInList(int randomNumber) {
        if (!randomNumbersList.contains(randomNumber)) {
            randomNumbersList.add(randomNumber);
        }
    }

}

