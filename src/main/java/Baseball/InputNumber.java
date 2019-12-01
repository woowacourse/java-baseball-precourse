package Baseball;

import java.util.Scanner;

public class InputNumber {
    private static int inputNumber;
    private static Scanner scanner = new Scanner(System.in);
    private static boolean[] usedNumber;

    public void input(){
        System.out.println("숫자를 입력해주세요 : ");
        inputNumber = scanner.nextInt();
        if(!isAvailableInput(inputNumber)){
            input();
        }
    }

    private boolean isAvailableInput(int inputNumber){
        int toCheckInputNumber = inputNumber;
        usedNumber = new boolean[10];
        if((toCheckInputNumber < 100) || (toCheckInputNumber > 999)){
            return false;
        }

        while(toCheckInputNumber != 0){
            int num = toCheckInputNumber % 10;
            if(usedNumber[num]) {
                return false;
            }
            usedNumber[num] = true;
            toCheckInputNumber = toCheckInputNumber / 10;
        }
        return true;
    }

    public int getInputNumber(){
        return inputNumber;
    }

}
