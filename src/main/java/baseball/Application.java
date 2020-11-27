package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 사용자 입력
        String playerInput;
        System.out.println("숫자를 입력해 주세요 : ");
        playerInput = scanner.next();
        System.out.println("inputData: " + playerInput);

        // 랜덤숫자 세팅
        String randomNumbers = makeRandomNumber();
        System.out.println("randomNumbers: " + randomNumbers);
    }

    private static String makeRandomNumber() {
        String randomNumbers = "";
        for (int randomIndex = 0; randomIndex < 3; randomIndex++) {
            randomNumbers += RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        }
        return randomNumbers;
    }


}
