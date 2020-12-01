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

    // 입력결과를 바탕으로 볼 스트라이크 정보 제공
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

    // 스트라이크가 3개인지 확인
    public static boolean checkResult(int strike){
        if(strike == MAX_LENGTH){
            return true;
        }
        return false;
    }

    // 새게임 진행 여부 확인
    public static boolean continueGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner s = new Scanner(System.in);
        while(true){
            String continueGameNumber = s.nextLine();

            if (!validateContinueGameNumber(continueGameNumber)){
                System.out.println("다시 입력해주세요");
                continue;
            }

            if (continueGameNumber.compareTo("1") == 0){
                System.out.println("새로운 게임을 시작합니다.");
                return true;
            }
            System.out.println("프로그램을 종료합니다.");
            return false;
        }
    }
}
