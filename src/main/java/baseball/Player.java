package baseball;


import utils.RandomUtils;

import java.util.Scanner;

import static baseball.Game.*;

public class Player {

    public static void playGame(Scanner scanner){
        String gameNumber = makeGameNumber();
        System.out.println(gameNumber);

        while (true){
            String inputNumber = scanner.nextLine();

            // 숫자 확인
            boolean isNumeric = inputNumber.chars().allMatch(Character::isDigit);

            // 길이 확인
            boolean compareLength = inputNumber.length() == gameNumber.length();

            if (!isNumeric || !compareLength) {
                System.out.printf("%b %b \n",isNumeric,compareLength);
                continue;
            }

            // 입력값 중복 확인 (추가)

            // 볼,스트라이크 체크
            int strike = countStrike(gameNumber,inputNumber);
            int ball = countBall(gameNumber,inputNumber);
            printHint(strike,ball);

            // 3스트라이크 게임 종료
            if(checkResult(strike)){
                break;
            }
        }
    }


}

