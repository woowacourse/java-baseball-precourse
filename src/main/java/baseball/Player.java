package baseball;

import java.util.Scanner;

public class Player {
    private int strikeCount = 0, ballCount = 0;
    private String inputNumber = "";

    public void playerGamePlay(Scanner scanner, RandomNumberGenerator randomNumber){
        inputNumber = setPlayerNumber(scanner);
        checkPlayerScore(inputNumber, randomNumber);
    }

    private String setPlayerNumber(Scanner scanner){
        try{
            IllegalArgumentException e = new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);

            System.out.print(Constants.INPUT_REQ_MESSAGE);
            String inputNumber = scanner.next();
            if (isCorrectNumber(inputNumber)) {
                return inputNumber;
            } else {
                throw e;
            }

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + Constants.RESTART_REQ_MESSAGE);
            return setPlayerNumber(scanner);
        }
    }

    private boolean isCorrectNumber(String inputNumber){
        boolean[] isUsedNumber = new boolean[Constants.NUMBER_LIMIT + 1];

        if (inputNumber.length() != Constants.NUMBER_COUNT) {
            return false;
        }
        if (!isNumber(inputNumber)){
            return false;
        }
        if (Integer.parseInt(inputNumber) < 0) {
            return false;
        }

        for(int i = 0 ; i < Constants.NUMBER_COUNT; ++i){
            int number = inputNumber.charAt(i) - '0';
            if (number == 0) {
                return false;
            } else if (isUsedNumber[number]) {
                return false;
            }
            isUsedNumber[number] = true;
        }
        return true;
    }

    private boolean isNumber(String inputNumber){
        for(int i = 0 ; i < Constants.NUMBER_COUNT; ++i){
            if (!Character.isDigit(inputNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private void checkPlayerScore(String inputNumber, RandomNumberGenerator randomNumber){
        strikeCount = 0;
        ballCount = 0;
        for(int numberOrder = 0 ; numberOrder < Constants.NUMBER_COUNT; ++numberOrder){
            int number = inputNumber.charAt(numberOrder) - '0';

            if (number == randomNumber.answerNumbers[numberOrder]){
                strikeCount++;
            } else if(randomNumber.isUsedNumber[number]) {
                ballCount++;
            }
        }
    }

    public int getStrikeCount(){
        return this.strikeCount;
    }

    public int getBallCount(){
        return this.ballCount;
    }
}
