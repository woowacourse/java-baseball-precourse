package baseball;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Exception exception = new Exception();
    private static final String INPUTNUMBER = "숫자를 입력해주세요 : ";
    Scanner scanner = new Scanner(System.in);
    private int input;
    private String stringInput="";
    public String playerInput()
    {
        System.out.print(INPUTNUMBER);
        this.stringInput=scanner.nextLine();
        return this.stringInput;
    }
    public void correctInput(){
        playerInput();

        if(!checkingInput(this.stringInput)){
            correctInput();
        }
        else{
            this.input=Integer.parseInt(this.stringInput);
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
        if( exception.inZero(stringInput)||exception.correctLen(stringInput)||exception.inExceptNumber(stringInput)|| exception.inDuplicateNumber(stringInput)|| exception.inNegative(stringInput)){
            return false;
        }
        return true;
    }

    public ArrayList<Integer> getInputToArrayList() throws IllegalArgumentException{


        correctInput();
        String convertInput=Integer.toString(this.input);
        ArrayList<Integer> inputNumber= new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            inputNumber.add(convertInput.charAt(i)-'0');
        }
        //System.out.println(convertInput);
        return inputNumber;
    }
}
