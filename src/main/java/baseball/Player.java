package baseball;


import utils.RandomUtils;

import java.util.Scanner;

import static baseball.Constant.MAX_LENGTH;
import static baseball.Game.*;
import static baseball.Validation.validateInputNumber;

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


}

