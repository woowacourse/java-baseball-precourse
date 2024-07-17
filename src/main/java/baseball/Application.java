package baseball;

import java.util.*;

public class Application {


    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        // 1. 컴퓨터 랜던 넘버 테스트
        Computer cm = new Computer();
//        System.out.println(cm.computerRandom());


        // 2. 입력을 검사하는 기능
        // 숫자 길이4
//        String userInput = "423";
//        List<Integer> test = cm.takeUserInput(userInput);
//        // 숫자가 아닌 다른 숫자
//        String userInput2 = "a23";
//        List<Integer> ss2 = cm.takeUserInput(userInput2);
//        System.out.println(ss2);
//        // 둘다
//        String userInput3 = "1a23";
//        List<Integer> ss3 = cm.takeUserInput(userInput3);
//        System.out.println(ss3);




        // 3. 볼,스트라이트. 낫싱 계산 기능 // 유저 4,2,3 컴퓨터가 1,2,3 일때

        String userInput = "567";
        List<Integer> test = cm.takeUserInput(userInput);

        cm.customComputerRandomNumber(new int[]{1,2,3});
        Map<String, Integer> map = cm.userInputResult(test);
        System.out.println(map);

        // 4. 2)3) 합치고 종료 및


    }

}

