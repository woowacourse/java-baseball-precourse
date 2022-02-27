package ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Output {

    public static void printRequestNumberInput(){

        System.out.println("숫자를 입력해주세요 : ");

    }


    public static void printStrikeAndBallCount(int strikeCount, int ballCount){

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printRequestRestartInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printGameOver(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
