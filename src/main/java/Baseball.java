/**
 * Baseball class
 *
 * v1.0
 *
 * 2019-11-29
 *
 * MIT Licence
 */
import java.io.PrintStream;
import java.util.Random;
import  java.util.Scanner;


public class Baseball {

    /*게임 진행 클래스*/
    private String answer;
    private int stringMaxLength = 3;
    private PrintStream printStream = System.out;
    Baseball() {
        answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stringMaxLength; i++) {
            sb.append(makeNumber());
        }
        answer = sb.toString();
    }

    public boolean doBaseball() {
        String option;
        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = getInput();
            int strike = getStrike(input); //스트라이크 수
            int ball = getBall(input); //볼 수

            if (strike == stringMaxLength) {
                printStream.println("3 strike"); //3스트라이크 시
                printStream.println("You got an answer! end game");
                break;
            } else if (strike + ball == 0) {
                printStream.println("nothing"); //모든 숫자가 빗나갔다면
            } else {
                printStream.println(strike + " Strike, " + ball + " Ball"); //하나라도 맞는다면
            }
        }
        printStream.println("To start new game press 1, Finish the game press 2");

        while (true) {
            option = scan.nextLine(); //유효한 입력을 받을때까지 루프

            if (option.equals("1")) {
                return true; //계속 플레이
            } else if (option.equals("2")) {
                return false; //플레이 중지
            }
            printStream.println("Input Correct option");
        }
    }

    public String getInput() {
        String input;
        Scanner scan = new Scanner(System.in);

        while (true) {

            //유효한 입력을 받을때까지 실행
            int input_number; //입력받은 숫자

            printStream.println("Input the Number: ");
            input = scan.nextLine();

            try {
                input_number = Integer.parseInt(input);
            } catch (Exception e) {

                //문자열에 숫자가 아닌게 있을때
                printStream.println("Input only Number");
                continue;
            }
            input = Integer.toString(input_number);

            if (input.length() != stringMaxLength) {

                //문자열 길이가 3자리가 안될때
                printStream.println("Please input 3-length number");
                continue;
            } else if ((input.charAt(0) == input.charAt(1)) || (input.charAt(0) == input.charAt(2))
                    || (input.charAt(1) == input.charAt(2))) {

                //중복된 숫자가 들어올때
                printStream.println("Please do not input duplicated number");
                continue;
            }
            break;
        }
        return input;
    }

    public int getStrike(String input) {

        //스트라이크수 계산
        int strike = 0;

        for (int i = 0; i < stringMaxLength; i++){

            if(input.charAt(i) == answer.charAt(i)){
                strike++;
            }
        }
        return strike;
    }

    public int getBall(String input) {

        //볼 수 계산
        int ball = 0;

        for (int i = 0; i < stringMaxLength; i++) {

            for (int j = 0; j < stringMaxLength; j++) {

                if (i != j && input.charAt(i) == answer.charAt(j)) {
                    ball++;
                    break;
                }
            }
        }
        return ball;
    }

    public String makeNumber() {

        //한자리씩 랜덤한 숫자를 뽑는다
        Random rand = new Random();
        int temp;

        while (true) {
            temp = rand.nextInt(8) + 1;
            String currentNumber = Integer.toString(temp);

            if (!answer.contains(currentNumber)) {
                return currentNumber;
            }
        }
    }
}
