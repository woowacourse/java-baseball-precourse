package baseball;

import jdk.vm.ci.code.CodeUtil;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        final int NUMBER_LENGTH = 3;

        String randomNumber = generateNumbers(NUMBER_LENGTH);

    }

    //1에서 9까지 서로 다른 임의의 수 3개를 생성하는 함수
    public static String generateNumbers(int numberLength){
        String returnNumber = "";
        while(returnNumber.length() < numberLength){
            //숫자를 생성해서 String으로 형변환 한다
            String tempNumber = Integer.toString(RandomUtils.nextInt(0,9));
            if(!returnNumber.contains(tempNumber)){
                returnNumber += tempNumber;
            }
        }
        return returnNumber;
    }
}
