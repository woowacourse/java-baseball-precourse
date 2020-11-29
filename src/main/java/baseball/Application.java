package baseball;

import jdk.vm.ci.code.CodeUtil;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        final int NUMBER_LENGTH = 3;

        String randomNumber = RandomNumber.generateNumbers(NUMBER_LENGTH);
        System.out.print(randomNumber);
    }
}
