package baseball;

import jdk.vm.ci.code.CodeUtil;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static final int NUMBER_LENGTH = 3;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        //임의의 수를 생성한다
        String randomNumber = RandomNumber.generateNumbers(NUMBER_LENGTH);
        //유저에게 숫자를 입력받는다
        String inputNumber = InputNumber.getInput(scanner);
        String result = "";

        //입력값의 범위를 벗어나서 경고 메세지를 받은 경우
        if (inputNumber.length() != NUMBER_LENGTH){
            System.out.println(inputNumber);
        }else{  //심판에게 판단을 받는다
            result = Referee.judgeNumber(randomNumber, inputNumber);
        }
        System.out.println(randomNumber);
        System.out.println(inputNumber);
    }
}
