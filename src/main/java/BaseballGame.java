import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
    int[] computerNum = new int[3];
    int[] playerNum = new int[3];
    int[] results = new int[2]; // Index 0 : strike, Index 1 : ball info

    //get 3 different random numbers
    computerNum = fillArray(computerNum);
    //System.out.println(Arrays.toString(computerNum));

    //get input from user
    playerNum = getInput(playerNum);
    //System.out.println(Arrays.toString(playerNum));

    results[0] = getStrikeInfo(computerNum, playerNum);
    //System.out.println(results[0]);

    }

    private static int[] fillArray(int[] myArray) {
        myArray[0] = getNewNumber();
        myArray[1] = getNewNumber();
        while (myArray[0] == myArray[1]) {
            myArray[1] = getNewNumber();
        }
        myArray[2] = getNewNumber();
        while ((myArray[0] == myArray[2]) | (myArray[1] == myArray[2])) {
            myArray[2] = getNewNumber();
        }
        return myArray;
    }

    private static int getNewNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(9) + 1;
    }

    private static int[] getInput(int[] myArray) {
        Scanner myScanner = new Scanner(System.in);
        boolean correctInput = false;
        int temp = -1;
        while (!correctInput) {
            System.out.print("숫자를 입력해주세요: ");
            temp = myScanner.nextInt();
            if (100 <= temp & temp <= 999 )
                correctInput = true;
            else
                System.out.println("잘못된 값 입니다");
        }
        myArray[0] = temp/100;
        temp = temp%100;
        myArray[1] = temp/10;
        myArray[2] = temp%10;
        return myArray;
    }

    private static int getStrikeInfo(int[]array1, int[]array2) {
        int strikeNum = 0;
        for (int i = 0; i < 3; i ++) {
            if (array1[i] == array2[i])
                strikeNum += 1;
        }
        return strikeNum;
    }
}
