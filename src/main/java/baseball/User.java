package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class User {

    public static String user_Num(){
        System.out.print("숫자를 입력해주세요 : ");
        String num;
        num=Console.readLine();

        is_one_to_nine(num);
        isMatchLength(num);
        isOverlap(num);

        return num;
    }

    public static boolean isContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String press;
        press=Console.readLine();
        is_one_to_two(press);

        if (press.equals("1")) {
            return true;
        }
        else if (press.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }


    public static void is_one_to_nine(String num){
        String [] card = {"1","2","3","4","5","6","7","8","9"};
        String [] array_user;

        array_user=num.split("");
        for (String e : array_user){

            if (!Arrays.asList(card).contains(e)){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isMatchLength(String num){

        if (num.length()!=3){
            throw new IllegalArgumentException();

        }

    }

    private static void isOverlap(String num) {
        char[] userNumber = num.toCharArray();

        if (userNumber[0] == userNumber[1] || userNumber[0] == userNumber[2] || userNumber[1] == userNumber[2]) {
            throw new IllegalArgumentException();
        }

    }

    public static void is_one_to_two(String num){
        String [] card = {"1","2"};
        String [] array_user;

        array_user=num.split("");
        for (String e : array_user){

            if (!Arrays.asList(card).contains(e)){
                throw new IllegalArgumentException();
            }
        }
    }

}
