package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {


    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        // 랜덤 넘버
        Computer cm = new Computer();
//        System.out.println(cm.computerRandom());


        // 잘된 input 인가 테스트
        // 숫자 길이4
        String userInput = "1423";
        List<Integer> ss = cm.takeUserInput(userInput);
//        // 숫자가 아닌 다른 숫자
//        String userInput2 = "a23";
//        List<Integer> ss2 = cm.takeUserInput(userInput2);
//        System.out.println(ss2);
//        // 둘다
//        String userInput3 = "1a23";
//        List<Integer> ss3 = cm.takeUserInput(userInput3);
//        System.out.println(ss3);


    }

}

