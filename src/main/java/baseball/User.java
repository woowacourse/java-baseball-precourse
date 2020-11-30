package baseball;

import java.util.Scanner;

public class User {
    public static int[] getGuess(Scanner kbd) throws IllegalArgumentException {
        int[] guessList;
        String strGuess;
        while(true) {
            try {
                displayInputMessage(); //입력받는 문구 출력
                strGuess = userInput(kbd);
                checkLength(strGuess); //3자리가 아닐 경우
                checkInteger(strGuess); //숫자가 아닐 경우
                guessList = strToIntList(strGuess);
                checkDuplication(guessList); //중복된 숫자가 있을 경우
                break;
            } catch (Exception e) {
                System.out.println("1~9의 서로 다른 수로 이루어진 3자리 수를 입력해주세요");
            }
        }
        return guessList;
    }

    private static void displayInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static String userInput(Scanner kbd) {
        return kbd.next();
    }

    private static int[] strToIntList(String strGuess) {
        /* 입력받은 세자리 수를 int형 리스트로 변환 */
        int[] guessList = new int[3];
        for (int i = 0; i < strGuess.length(); i++)
            guessList[i] = Integer.parseInt(strGuess.charAt(i)+"");
        return guessList;
    }

    private static void checkLength(String strGuess) {
        /* 입력받은 글자의 길이가 3인지 확인 */
        if (strGuess.length() != 3)
            throw new IllegalArgumentException();
    }

    private static void checkInteger(String strGuess) {
        /* 입력받은 글자의 각 자리가 모두 정수이며 1~9에 해당하는지 확인 */
        boolean flag = false;
        for(int i = 0; i < strGuess.length(); i++) {
            char c = strGuess.charAt(i);
            if (c < '1' || c < '9')
                flag = true;
        }
        if (flag == false)
            throw new IllegalArgumentException();
    }

    private static void checkDuplication(int[] guess) {
        /* 입력받은 세 자리 수에 중복된 값이 없는지 확인 */
        if (guess[0] == guess[1] || guess[0] == guess[2] || guess[1] == guess[2])
            throw new IllegalArgumentException();
    }
}
