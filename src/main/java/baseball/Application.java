package baseball;

import java.util.Arrays;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    static public final Scanner scanner = new Scanner(System.in);
    static public int[] targetNumbers = {0,0,0};
    static public int[] numberChecker = {0,0,0,0,0,0,0,0,0,0};

    public static void initNumberChecker(){
        for(int i = 0; i < 3; i++){
            numberChecker[targetNumbers[i]] = 0;
        }
    }

    public static void getRandomNumbers(){
        int i = 0;
        while(i < 3){
            final int newNumber = RandomUtils.nextInt(1,9);
            if(numberChecker[newNumber] == 0){
                numberChecker[newNumber] = 1;
                targetNumbers[i] = newNumber;
                i++;
            }
        }
    }
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
