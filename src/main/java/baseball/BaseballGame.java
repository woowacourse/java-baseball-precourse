package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private String computerNumber;
    private String playerNumber;

    public BaseballGame(String computerNumber, String playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        checkAnswerException(number);
        if(number.equals("1")) {
            return true;
        }
        return false;
    }

    public void checkAnswerException(String number) {
        InputValidator inputValidator=new InputValidator();
        if(!inputValidator.isNumber(number) || !inputValidator.checkSelectScope(number)) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        while(true) {
            inputNumber();
            compareNumber();
            if(calcStrike() == 3) {
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        checkNumberException(number);
        this.playerNumber = number;
    }

    public void checkNumberException(String number) {
        InputValidator inputValidator=new InputValidator();
        if(!inputValidator.isNumber(number) || !inputValidator.checkLength(number,computerNumber.length())
                || !inputValidator.checkNumberScope(number) || !inputValidator.checkDistinct(number)) {
            throw new IllegalArgumentException();
        }
    }

    public int calcStrike() {
        int count=0;
        for(int i=0; i<computerNumber.length(); i++) {
            if(computerNumber.charAt(i)==playerNumber.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int calcBall() {
        int count=0;
        for(int i=0; i<playerNumber.length(); i++) {
            String s = playerNumber.substring(i,i+1);
            int sameIndex = computerNumber.indexOf(s);
            if(sameIndex != -1 && sameIndex != i) {
                count++;
            }
        }
        return count;
    }

    public void compareNumber() {
        int ball = calcBall();
        int strike = calcStrike();
        printResult(ball,strike);
    }

    public void printResult(int ball,int strike) {
        if(ball != 0) {
            System.out.print(ball + "볼");
            if(strike != 0) {
                System.out.print(" ");
            }
        }
        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

}
