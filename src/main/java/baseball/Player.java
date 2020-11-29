package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Exception exception = new Exception();
    private static final String INPUTNUMBER = "숫자를 입력해주세요 : ";
    Scanner scanner = new Scanner(System.in);
    private int INPUT;
    private String STRINGINPUT="";
    public String playerInput()
    {
        System.out.print(INPUTNUMBER);
        this.STRINGINPUT =scanner.nextLine();
        return this.STRINGINPUT;
    }
    public void correctInput(){
        playerInput();

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
        if( exception.inZero(stringInput)||exception.correctLen(stringInput)||exception.inExceptNumber(stringInput)|| exception.inDuplicateNumber(stringInput)|| exception.inNegative(stringInput)){
            return false;
        }
        return true;
    }

    public ArrayList<Integer> getInputToArrayList() throws IllegalArgumentException{


        correctInput();
        String convertInput=Integer.toString(this.INPUT);
        ArrayList<Integer> inputNumber= new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            inputNumber.add(convertInput.charAt(i)-'0');
        }
        //System.out.println(convertInput);
        return inputNumber;
    }
}
