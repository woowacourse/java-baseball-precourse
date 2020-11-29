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

    public static boolean checkAnswer(String input){
        int[] inputNumbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        int strikeConut = 0;
        int ballConut = 0;
        for(int i = 0; i < 3; i++){
            if(inputNumbers[i] == targetNumbers[i]) strikeConut++;
            else if(numberChecker[inputNumbers[i]] == 1) ballConut++;
        }
        if(strikeConut == 3) return true;
        System.out.println("strikeConut : " + strikeConut);
        System.out.println("ballConut : " + ballConut);
        return false;
    }

    public static boolean isValidInput(String input){
        if(input.length() != 3) return false;
        for(int i = 0; i < 3; i++){
            if(input.charAt(i) < '1' || input.charAt(i) > '9') return false;
        }
        if(input.charAt(0) == input.charAt(1)) return false;
        if(input.charAt(0) == input.charAt(2)) return false;
        if(input.charAt(1) == input.charAt(2)) return false;
        return true;
    }

    public static void play(){
        initNumberChecker();
        getRandomNumbers();
        while(true){
            System.out.println("숫자를입력해주세요 : ");
            String input = scanner.nextLine().trim();
            if(!isValidInput(input)) {
                System.out.println("입력을 확인해 주세요.");
                continue;
            }
            if(checkAnswer(input)) return;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
