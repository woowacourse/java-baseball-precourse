package baseball;


import utils.RandomUtils;

import java.util.Scanner;

import static baseball.Constant.MAX_LENGTH;
import static baseball.Game.*;

public class Player {

    public static void playGame(Scanner scanner){
        String gameNumber = makeGameNumber();
        System.out.println(gameNumber);

        while (true){
            String inputNumber = scanner.nextLine();

            if(!validateInputNumber(inputNumber)){
                System.out.println("다시 입력해주세요");
                continue;
            }

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

    //
    public static boolean validateInputNumber(String inputNumber){
        if (!isNumeric(inputNumber) ||
            !compareLength(inputNumber) ||
            !isReduplication(inputNumber)){
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String inputNumber){
        return inputNumber.chars().allMatch(Character::isDigit);
    }

    public static boolean compareLength(String inputNumber){
        return inputNumber.length() == MAX_LENGTH;
    }

    public static boolean isReduplication(String inputNumber){
        return false;
    }



}

