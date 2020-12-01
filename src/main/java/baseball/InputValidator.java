package baseball;

public class InputValidator {
    public static boolean checkInputNumber(String number){
        if(number.length()!=GamePlayer.NUMBER_LENGTH){ // in case of inputting length not NUMBER_LENGTH
            return false;
        }
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0};
        for(int i = 0; i<GamePlayer.NUMBER_LENGTH;i++){ // check duplicate
            int checkNum = Character.getNumericValue(number.charAt(i));
            if(arr[checkNum-1]==0){
                arr[checkNum-1]+=1;
            }else{ // already has same num at different index
                return false;
            }
        }
        try{   // case of not numeric
            Integer.parseInt(number);
            return true;
        }catch(NumberFormatException e){ // in case of inputting not integer string
            return false;
        }
    }
}
