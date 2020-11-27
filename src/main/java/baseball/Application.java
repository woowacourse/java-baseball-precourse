package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        Validate validate = new Validate();
        // 게임 상태, 초기 0, 재시작 1, 완전종료 2, 게임종료 3
        int flag = 1;
        String randomNumbers ="";
        while (flag != 2)
        {
            if (flag == 1) {
                // 랜덤숫자 세팅
                flag = 0;
                randomNumbers = makeRandomNumber();
                System.out.println("randomNumbers: " + randomNumbers);
            }
            // 사용자 입력
            try{
                System.out.println("숫자를 입력해 주세요 : ");
                String playerInput = scanner.next();
                if (isValidInput(playerInput, validate))
                    System.out.println("inputData: " + playerInput);
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean isValidInput(String playerInput, Validate validate)
    {
        if (validate.isValidInputSize(playerInput) &&
                validate.isNumberInteger(playerInput))
            return true;
        return false;
    }

    private static String makeRandomNumber() {
        String randomNumbers = "";
        for (int randomIndex = 0; randomIndex < 3; randomIndex++) {
            randomNumbers += RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        }
        return randomNumbers;
    }
}
