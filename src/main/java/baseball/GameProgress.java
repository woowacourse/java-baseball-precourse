package baseball;

import java.util.Scanner;

public class GameProgress {

    private int strikeCount = 0, ballCount = 0;
    private String inputNumber = "";

    public void getPlayerNumber(Scanner scanner, GameSetting gameSetting){
        inputNumber = playerInput(scanner);
        scoreCheck(inputNumber, gameSetting);
    }

    public String playerInput(Scanner scanner){
        try{
            String inputNumber = scanner.next();
            if (isCorrectNumber(inputNumber) == false) {
                IllegalArgumentException e = new IllegalArgumentException("잘못된 입력입니다");
                throw e;
            }
            return inputNumber;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + " 다시 입력해주세요");
            return playerInput(scanner);
        }
    }

    public boolean isCorrectNumber(String inputNumber){
        boolean[] isUsedNumber = new boolean[Constants.NUMBER_LIMIT + 1];

        if (Integer.parseInt(inputNumber) < 0) return false;
        if (inputNumber.length() < Constants.NUMBER_COUNT) return false;

        for(int i = 0 ; i < Constants.NUMBER_COUNT; ++i){
            int number = inputNumber.charAt(i) - '0';
            if (number == 0) return false;
            if (isUsedNumber[number]) return false;
            isUsedNumber[number] = true;
        }
        return true;
    }

    public void scoreCheck(String inputNumber, GameSetting gameSetting){
        strikeCount = 0;
        ballCount = 0;
        for(int numberOrder = 0 ; numberOrder < Constants.NUMBER_COUNT; ++numberOrder){
            int number = inputNumber.charAt(numberOrder) - '0';

            if (number == gameSetting.randomNumberGenerator.answerNumbers[numberOrder]) strikeCount++;
            else if(gameSetting.randomNumberGenerator.isUsedNumber[number]) ballCount++;
        }
    }

    public int getStrikeCount(){
        return this.strikeCount;
    }

    public int getBallCount(){
        return this.ballCount;
    }

}
