package baseballgame.inputvalidator;

import baseballgame.CommonConstant;

public class Validator {
    public Validator(){

    }
    public static void validateUserInputOnGame(String inputNumber) {
        try {
            if(inputNumber.length()!=3) throw new Exception();
            if(inputNumber.contains("0")) throw new Exception();
            if(!isDifferentAllNumber(inputNumber)) throw new Exception();
            Integer.parseInt(inputNumber);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
    public static void validateUserInputOnFinishedGame(String inputNumber){
        try {
            if(inputNumber.length()!=1) throw new Exception();
            if(!(inputNumber.equals(CommonConstant.NEW_GAME_STATE)
                    ||inputNumber.equals(CommonConstant.FINISH_GAME_STATE))) throw new Exception();
            Integer.parseInt(inputNumber);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
    private static boolean isDifferentAllNumber(String inputNumber){
        boolean test1 = inputNumber.charAt(0) != inputNumber.charAt(1);
        boolean test2 = inputNumber.charAt(0) != inputNumber.charAt(2);
        boolean test3 = inputNumber.charAt(1) != inputNumber.charAt(2);

        return test1 && test2 && test3;
    }
}
