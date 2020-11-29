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

        System.out.println(randomNumber);
        System.out.println(inputNumber);
    }
}
