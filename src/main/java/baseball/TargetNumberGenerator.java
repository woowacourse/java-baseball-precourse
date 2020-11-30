package baseball;

import utils.RandomUtils;

public class TargetNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int ONES_PLACE = 1;
    private static final int TENS_PLACE = 10;
    private static final int HUNDREDS_PLACE = 100;

    /**
     * 메서드 makeTargetNumber()는 플레이어가 맞춰야할 중복되지 않는 임의의 수 3개를 정하는 역할
     * @return 1에서 9까지 서로 다른 임의의 수 3개를 리턴
     */
    public static int makeTargetNumber() {
        int firstTargetNumber = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);

        int secondTargetNumber = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        while(firstTargetNumber == secondTargetNumber) {
            secondTargetNumber = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        }

        int thirdTargetNumber = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        while((firstTargetNumber == thirdTargetNumber) || (secondTargetNumber == thirdTargetNumber)) {
            thirdTargetNumber = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        }

        return ((firstTargetNumber * HUNDREDS_PLACE) + (secondTargetNumber* TENS_PLACE)
                + (thirdTargetNumber * ONES_PLACE));
    }
}
