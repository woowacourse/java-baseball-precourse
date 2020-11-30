package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Exception exception = new Exception();
    Scanner scanner = new Scanner(System.in);
    private static final String INPUTNUMBER = "숫자를 입력해주세요 : ";
    private int INPUT;
    private String STRINGINPUT="";
    private static final int LENGTHNUMBER=3;

    public String playerInputNumber() {
        System.out.print(INPUTNUMBER);
        this.STRINGINPUT =scanner.nextLine();
        return this.STRINGINPUT;
    }
    public String playerChoiceNumber() {
        this.STRINGINPUT =scanner.nextLine();
        return this.STRINGINPUT;
    }
    public void correctInput(){
        playerInputNumber();
        if(!checkingInput(this.STRINGINPUT)){
            correctInput();
        }
        else{
            this.INPUT =Integer.parseInt(this.STRINGINPUT);
        }
    }
    public boolean checkingInput(String stringInput){
        try{
            return validateInput(stringInput);
        }catch (IllegalArgumentException e){
            System.out.println(e);
            return false;
        }
    }
    public boolean validateInput(String stringInput) throws IllegalArgumentException{
        if(exception.inExceptNumber(stringInput)|| exception.correctLen(stringInput)|| exception.inNegative(stringInput)|| exception.inZero(stringInput)||exception.inDuplicateNumber(stringInput)){
            return false;
        }
        return true;
    }

    public ArrayList<Integer> getInputToArrayList(){

        correctInput();
        String convertInput=Integer.toString(this.INPUT);
        ArrayList<Integer> inputNumber= new ArrayList<Integer>();
        for(int i=0;i<LENGTHNUMBER;i++){
            inputNumber.add(convertInput.charAt(i)-'0');
        }
        return inputNumber;
    }
    public int getChoiceNumber(){
        String choiceNumber=playerChoiceNumber();
        if(!checkChoiceNumber(choiceNumber)){
            return getChoiceNumber();
        }
        else{
            return Integer.parseInt(choiceNumber);
        }

    }
    public boolean checkChoiceNumber(String choiceNumber){
        try{
            return exception.inExceptNumber(choiceNumber)||exception.navigateChoiceNumber(choiceNumber);
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return false;
        }
    }
}
