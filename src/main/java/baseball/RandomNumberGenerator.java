package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int[] generateThreeRandomDigits() {
        int[] threeRandomDigits = new int[Constant.DIGIT_NUM];
        threeRandomDigits[0] = Randoms.pickNumberInRange(Constant.START_NUM, Constant.END_NUM);

        for (int i = 1; i < Constant.DIGIT_NUM; i++) {
            threeRandomDigits[i] = pickUniqueNumber(threeRandomDigits, i);
        }
        return threeRandomDigits;
    }

    private static int pickUniqueNumber(int[] threeRandomDigits, int index) {
        int newPick = Randoms.pickNumberInRange(Constant.START_NUM, Constant.END_NUM);
        while (isDuplicated(threeRandomDigits, index, newPick)) {
            newPick = Randoms.pickNumberInRange(Constant.START_NUM, Constant.END_NUM);
        }
        return newPick;
    }

    private static boolean isDuplicated(int[] pickedNumbers, int index, int newPick) {
        boolean isDuplicated=false;
        for (int i = 0; i < index; i++) {
            isDuplicated=(pickedNumbers[i] == newPick);
        }
        return isDuplicated;
    }
}
