package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // 기능 1: 랜덤 값 생성
        String targetNumber = randomNumber();

        while(true){
            //  기능 2: 사용자로부터 값 입력받기
            System.out.print("숫자를 입력해주세요: ");
            String inputNumber = Console.readLine();
        }
    }


    public static String randomNumber(){

        String firstNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String secondNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String thirdNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));

        return firstNumber + secondNumber + thirdNumber;
    }
}
