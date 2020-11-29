package baseball;

import utils.RandomUtils;

public class Computer {

    static private String result;

    public void makeRandomNumber(){
        result = "";
        int digit = 0;
        while(digit < Constants.NUMBER_LEN){
            int number = RandomUtils.nextInt(Constants.MIN_NUMBER, Constants.MAX_NUMBER);

            if(!result.contains(String.valueOf(number))){
                result += number;
                digit++;
            }
        }
    }

    public boolean checkStrikeAndBall(String inputNumber){

        int countStrike = 0;
        int countBall = 0;

        for(int i=0;i<inputNumber.length();i++){
            char inputChar = inputNumber.charAt(i);
            char resultChar = result.charAt(i);

            if(checkStrike(inputChar, resultChar)){
                countStrike++;
            }
            else if(checkBall(inputChar)){
                countBall++;
            }
        }

        printHint(countStrike, countBall);

        if(countStrike == Constants.NUMBER_LEN){
            return true;
        }
        else{
            return false;
        }
    }

    private void printHint(int countStrike, int countBall){
        if(countStrike == 0 && countBall == 0){
            System.out.println("낫싱");
        }
        else if(countStrike == 0){
            System.out.println(countBall + "볼");
        }
        else if(countBall == 0){
            System.out.println(countStrike + "스트라이크");
        }
        else{
            System.out.println(countBall + "볼 " + countStrike + "스트라이크");
        }
    }

    private boolean checkBall(char inputChar){
        if(result.contains(String.valueOf(inputChar))){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkStrike(char inputChar, char resultChar){
        if(inputChar == resultChar){
            return true;
        }
        else {
            return false;
        }
    }
}
