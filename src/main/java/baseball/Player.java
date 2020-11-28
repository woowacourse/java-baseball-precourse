package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private static final String INPUTNUMBER = "숫자를 입력해주세요 : ";
    Scanner scanner = new Scanner(System.in);
    public int playerInput()
    {
        int input=scanner.nextInt();
        return input;
    }
    public ArrayList<Integer> getInputToArrayList(){
        System.out.print(INPUTNUMBER);
        String convertInput=Integer.toString(playerInput());
        ArrayList<Integer> inputNumber= new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            inputNumber.add(convertInput.charAt(i)-'0');
        }
        return inputNumber;
    }
}
