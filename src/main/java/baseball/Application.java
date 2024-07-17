package baseball;

import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {


    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        // 1. 컴퓨터 랜던 넘버 테스트
//        Computer cm = new Computer();
//        System.out.println(cm.computerRandom());


        // 2. 입력을 검사하는 기능
        // 숫자 길이4
//        String userInput0 = "1423";
//        List<Integer> test0 = cm.takeUserInput(userInput0);
//        System.out.println(test0);
//        // 숫자가 아닌 다른 숫자
//        String userInput2 = "a23";
//        List<Integer> ss2 = cm.takeUserInput(userInput2);
//        System.out.println(ss2);
//        // 둘다
//        String userInput3 = "1a23";
//        List<Integer> ss3 = cm.takeUserInput(userInput3);
//        System.out.println(ss3);




        // 3. 볼,스트라이트. 낫싱 계산 기능
        // 컴퓨터가 1,2,3 일때
        // 유저 4,2,3  -> 2스트라이크
        // 유저 1,2,3 -> 3스트라이크
        // 유저 3,2,1 -> 2볼 1스트라이크
        // 유저 3,1,2 -> 3볼

//        String userInput = "567";
//        List<Integer> test = cm.takeUserInput(userInput);
//
//        cm.customComputerRandomNumber(new int[]{1,2,3});
//        Map<String, Integer> map = cm.userInputResult(test);
//        System.out.println(map);

        // 4. 2)3) 합치고 낫싱 처리
        // 컴퓨터가 1,2,3 일때
        // 유저 4,2,3  -> 2스트라이크
        // 유저 1,2,3 -> 3스트라이크
        // 유저 3,2,1 -> 2볼 1스트라이크
        // 유저 3,1,2 -> 3볼
        // 유저 3,1,1,=> 중복된거 들어가면 안되서 추가 처리

//        String userInput = "312";  // 311이 왜 되는거지?
//        cm.customComputerRandomNumber(new int[]{1,2,3});
//        List<Integer> test = cm.takeUserInput(userInput);
//        System.out.println(test);
//        Map<String, Integer> map = cm.userInputResult(test);
//        System.out.println(map);
//        String result= cm.calculate(userInput);
//        System.out.println(result);

        int value = exitOrRestart("게임 종료");
        System.out.println(value);

    }


    // 종료 로직
    public static int exitOrRestart(String result){
        if(result.contains("게임 종료")){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String commandString = readLine();
            if(commandString.equals("1")){
                // 다시시작 // 함수 윗부분으로 가야된다
                return 1;
            } else if (commandString.equals("2")) {
                return 2;
            }
        }

        return -1;
    }

}

