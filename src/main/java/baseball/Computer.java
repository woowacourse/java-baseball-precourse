package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends Numbers{
    int[] randomValue;


    public void generateValidRandom () {
        // 랜덤 수 생성, 유효한 값이 아닐 경우 반복 생성.
        do {
            randomValue = convertNumberToArray(generateRandom());
        } while(!isValidNumber(randomValue));
    }


    private int generateRandom(){
         /*
            [definition]
            게임 시작 시, 랜덤값을 생성해 반환합니다.

            [parameters]
            count: 생성할 랜덤값 자릿수

            [return]
            생성된 랜덤 수
        **/
        int randomNumber = 0;
        randomNumber += Randoms.pickNumberInRange(1, 9) * 100;
        randomNumber += Randoms.pickNumberInRange(1, 9) * 10;
        randomNumber += Randoms.pickNumberInRange(1, 9);

        return randomNumber;

    }
}
