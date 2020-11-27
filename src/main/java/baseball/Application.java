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
        String roundResult = "";
        String playerInput = "";
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
                playerInput = scanner.next();
                if (isValidInput(playerInput, validate))
                    System.out.println("inputData: " + playerInput);
                roundResult = makeHint(playerInput, randomNumbers);
                System.out.println(roundResult);
                if (roundResult.charAt(0) == '3') {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    flag = 3;
                }
                if (flag == 3) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    flag = scanner.nextInt();
                }
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String makeRandomNumber() {
        String randomNumbers = "";
        for (int randomIndex = 0; randomIndex < 3; randomIndex++) {
            randomNumbers += RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        }
        return randomNumbers;
    }

    private static boolean isValidInput(String playerInput, Validate validate)
    {
        if (validate.isValidInputSize(playerInput) &&
                validate.isNumberInteger(playerInput))
            return true;
        System.out.println(validate.toString());
        return false;
    }

    private static String makeHint(String playerNums, String randomNums) {
        StringBuilder result = new StringBuilder();
        char[] player = playerNums.toCharArray();
        char[] random = randomNums.toCharArray();
        int ball = 0;
        int strike = 0;
        //스트라이크 찾기
        for (int i = 0; i < player.length; i++) {
            if (player[i] == random[i])
                strike++;
        }
        //볼 찾기
        for (int i = 0; i < player.length; i++) {
            if (randomNums.contains("" + player[i]))
                ball++;
        }
        ball = ball - strike;
        //낫싱
        if (ball > 0 && strike > 0) {
            result.append(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            result.append(ball + "볼");
        } else if (strike > 0) {
            result.append(strike + "스트라이크");
        } else
            result.append("낫싱");
        return result.toString();
    }
}
