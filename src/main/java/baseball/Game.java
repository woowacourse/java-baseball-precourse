package baseball;

import utils.RandomUtils;

import java.util.Scanner;

import static baseball.Constant.*;
import static baseball.Validation.*;

public class Game {

    // 1~9사이의 3자리 랜덤 숫자 생성
    public static String makeGameNumber(){
        String gameNumber = "";
        int countLength = 0;

        while (countLength < MAX_LENGTH) {
            int randomNumber = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);

            if (!gameNumber.contains(String.valueOf(randomNumber))) {
                gameNumber += randomNumber;
                countLength++;
            }
        }
        return gameNumber;
    }

    // 스트라이크 카운트 계산
    public static int countStrike(String gameNumber, String inputNumber){
        int strike = 0;
        for (int i = 0; i < MAX_LENGTH; i++){
            if(gameNumber.charAt(i) == inputNumber.charAt(i)){
                strike++;
            }
        }
        return strike;
    }
    // 볼 카운트 계산
    public static int countBall(String gameNumber, String inputNumber){
        int ball = 0;
        for (int i =0; i <MAX_LENGTH; i++){
            if (gameNumber.charAt(i) != inputNumber.charAt(i) && gameNumber.contains(String.valueOf(inputNumber.charAt(i))) ){
                ball++;
            }
        }
        return ball;
    }


    public static void printHint(int countStrike, int countBall){
        if(countBall == 0 && countStrike == 0){
            System.out.println("낫싱");
            return;
        }

        if(countBall == 0){
            System.out.println(countStrike+"스트라이크");
            return;
        }

        if(countStrike == 0){
            System.out.println(countBall+"볼");
            return;
        }

        System.out.println(countBall+"볼 "+countStrike+"스트라이크");
    }

    public static boolean checkResult(int strike){
        if(strike == MAX_LENGTH){
            return true;
        }
        return false;
    }

    public static boolean continueGame(){
        System.out.print("계속하려면 1 아니면 2 :");
        Scanner s = new Scanner(System.in);
        while(true){
            String continueGameNumber = s.nextLine();

            if (!validateContinueGameNumber(continueGameNumber)){
                System.out.println("다시 입력해주세요");
                continue;
            }

            if (continueGameNumber.compareTo("1") == 0){
                return true;
            }
            return false;
        }
    }
}
