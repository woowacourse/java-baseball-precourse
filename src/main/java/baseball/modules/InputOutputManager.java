package baseball.modules;

import java.util.Scanner;

public class InputOutputManager {
    static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final String WRONG_VALUE_MESSAGE = "잘못된 값입니다.";
    static final String WIN_PRAISE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String NOTHING = "낫싱";
    static final String STRIKE_FORMAT = "%d스트라이크 ";
    static final String BALL_FORMAT = "%d볼";

    Scanner scanner;
    private int numberSize;
    
    public InputOutputManager(final Scanner scanner, final int numberSize){
        if(ExceptionChecker.isNull(scanner)){
            throw new IllegalArgumentException();
        }

        if(numberSize <= 0){
            throw new IllegalArgumentException();
        }

        this.scanner = scanner;
        this.numberSize = numberSize;
    }

    public int[] askUserInputNumber(){
        System.out.print(REQUEST_INPUT_MESSAGE);
        String inputNumber = scanner.nextLine();
        try{
            return ParseHandler.stringToIntArray(inputNumber, numberSize);
        } catch(Exception e){
            System.out.println(WRONG_VALUE_MESSAGE);
            return askUserInputNumber();
        }
    }

    public void printRoundResult(final int strike, final int ball){
        if(strike < 0 || ball < 0){
            throw new IllegalArgumentException();
        }

        if(strike == 0 && ball == 0){
            System.out.println(NOTHING);
            return;
        }

        if(strike != 0){
            System.out.printf(STRIKE_FORMAT, strike);
        }

        if(ball != 0){
            System.out.printf(BALL_FORMAT, ball);
        }

        System.out.println();
    }

    public void printWinMessage(){
        System.out.println(WIN_PRAISE_MESSAGE);
    }

    public int askRestartGame(){
        System.out.println(ASK_RESTART_MESSAGE);
        String answer = scanner.nextLine();
        try{
            return ParseHandler.stringToOneOrTwo(answer);
        } catch(Exception e){
            return askRestartGame();
        }
    }
}
