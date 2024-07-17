package baseball;

import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {


    public static void main(String[] args) {

        gameStart();

    }

    public static void gameStart(){
        Computer baseBall = new Computer();
//        baseBall.customComputerRandomNumber(new int[]{1,2,3});

        // 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
        int exitcheck = -1;
        while(exitcheck<1){
            // 입력문
            // 숫자를 입력해주세요 :  (???)
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = readLine();
            String result = baseBall.calculate(inputString);
            System.out.println(result);

            exitcheck = exitOrRestart(result);
        }
        if(exitcheck == 1){
            gameStart();
        }else{
            System.out.println("게임 종료");
        }
    }


    // 종료 로직
    public static int exitOrRestart(String result){
        if(result.contains("게임 종료")){
            System.out.println("게임을 새로 시작하력려면 1, 종료하려면 2를 입력하세요.");
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

