package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private String computerNumber;
    private String playerNumber;

    public BaseballGame(String computerNumber, String playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        checkNumberException(number);
        return number;
    }

    public void checkNumberException(String number) {
        InputValidator inputValidator=new InputValidator();
        try {
            if(!inputValidator.isNumber(number) || !inputValidator.checkLength(number,3)
                || !inputValidator.checkNumberScope(number)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.exit(1);
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

    public boolean calcNothing() {
        if(calcStrike() == 0 && calcBall() == 0) {
            return true;
        }
        return false;
    }

}
