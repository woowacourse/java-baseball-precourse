package baseball;

import utils.RandomUtils;

public class RandomNumberGenerator {
    public int[] answerNumbers =  new int[Constants.NUMBER_COUNT];
    public boolean[] isUsedNumber = new boolean[Constants.NUMBER_LIMIT + 1];

    public void makeRandomNumber() {
        int numberCount = 0;
        while(numberCount != Constants.NUMBER_COUNT) {
            int candidateNumber = RandomUtils.nextInt(1, Constants.NUMBER_LIMIT);

            if (isUsedNumber[candidateNumber]) {
                continue;
            }
            isUsedNumber[candidateNumber] = true;
            answerNumbers[numberCount] = candidateNumber;
            numberCount++;
        }

        System.out.print("생성된 번호 : ");
        for(int numbers : answerNumbers){
            System.out.print(numbers);
        }
        System.out.println();
    }
}
