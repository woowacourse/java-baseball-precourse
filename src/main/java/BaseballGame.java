import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        boolean playGameFlag = true;
        while(playGameFlag) {
            playGame();
            playGameFlag = checkNewGame();
        }
    }

    private static void playGame() {

        int[] computerNum = new int[3];
        int[] playerNum = new int[3];
        int[] results = new int[2]; // Index 0 : strike, Index 1 : ball info
        boolean nothing = false;
        boolean gameEnd = false;

        //get 3 different random numbers
        computerNum = fillArray(computerNum);
        //System.out.println(Arrays.toString(computerNum));

        while(!gameEnd) {
            nothing = false;
            //get input from user
            playerNum = getInput(playerNum);
            //System.out.println(Arrays.toString(playerNum));

            results[0] = getStrikeInfo(computerNum, playerNum);
            results[1] = getBallInfo(computerNum, playerNum);
            if (results[0] == 0 & results[1] == 0)
                nothing = true;
            //System.out.println(Arrays.toString(results));
            //System.out.println(nothing);

            gameEnd = getResults(results, nothing);
        }
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
            if (inRange(temp) & noDuplicates(temp, myArray))
                correctInput = true;
            else
                System.out.println("잘못된 값 입니다");
        }

        return myArray;
    }

    private static boolean inRange(int temp) {
        return (100 <= temp & temp <= 999);
    }

    private static boolean noDuplicates(int temp, int[] myArray) {
        myArray[0] = temp/100;
        temp = temp%100;
        myArray[1] = temp/10;
        if (myArray[0]==myArray[1] || myArray[1] == 0)
            return false;
        myArray[2] = temp%10;
        return !(myArray[0] == myArray[2] ||myArray[1] == myArray[2] || myArray[2] == 0);
    }

    private static int getStrikeInfo(int[]array1, int[]array2) {
        int strikeNum = 0;
        for (int i = 0; i < 3; i ++) {
            if (array1[i] == array2[i])
                strikeNum += 1;
        }
        return strikeNum;
    }

    private static int getBallInfo(int[] array1, int[] array2) {
        int ballNum = 0;
        if ((array1[0] == array2[1]) | (array1[0] == array2[2]))
            ballNum += 1;
        if ((array1[1] == array2[0]) | (array1[1] == array2[2]))
            ballNum += 1;
        if ((array1[2] == array2[1]) | (array1[2] == array2[0]))
            ballNum += 1;

        return ballNum;
    }

    private static boolean getResults(int[] resultArray, boolean nothing) {
        if (nothing) {
            System.out.println("낫싱");
            return false;
        }

        if (resultArray[0] != 0)
            System.out.print(resultArray[0] + " 스크라이크 ");
        if (resultArray[1] != 0)
            System.out.print(resultArray[1] + " 볼");
        if (resultArray[0] == 3) {
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
        System.out.print("\n");
        return false;
    }

    private static boolean checkNewGame() {
        Scanner myScanner = new Scanner(System.in);
        boolean correctInput = false;
        int temp = -1;
        while (!correctInput) {
            System.out.print("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
            temp = myScanner.nextInt();
            if (temp == 1)
                return true;
            else if (temp == 2)
                return false;
            else
                System.out.println("잘못된 값 입니다");
        }
        return false;
    }
}
