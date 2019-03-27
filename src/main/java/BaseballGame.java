import java.util.Random;
import java.util.Arrays;

public class BaseballGame {
    public static void main(String[] args) {
    int[] computerNum = new int[3];
    computerNum = fillArray(computerNum);
    // System.out.print(Arrays.toString(computerNum));

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
}
