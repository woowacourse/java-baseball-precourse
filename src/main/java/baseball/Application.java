package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {

        String targetNumber = randomNumber();

    }

    // 1~9 사이의 랜덤 수 출력해서 3자리의 수로 리턴
    public static String randomNumber(){

        String firstNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String secondNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String thirdNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));

        return firstNumber + secondNumber + thirdNumber;
    }
}
