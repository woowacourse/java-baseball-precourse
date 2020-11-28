package baseball;

import java.util.Scanner;

public class InputReceiver {
    static final int NUMBEROFBALL = 3;
    static final IllegalArgumentException inputError = new IllegalArgumentException();
    static final Scanner receiver = new Scanner(System.in);

    public static int[] userAnswer() {
        int[] userAnswer;
        System.out.print("숫자를 입력해주세요 : ");
        String userInitialAnswer = receiver.nextLine();
        lengthChecker(userInitialAnswer);
        userAnswer = intergerArrayTranslator(userInitialAnswer);
        return userAnswer;
    }

    private static void lengthChecker(String userInitialAnswer) {
        if (userInitialAnswer.length()>3){
            throw inputError;
        }

        if (userInitialAnswer.length()<3){
            throw inputError;
        }
    }

    private static int[] intergerArrayTranslator(String userIntialAnswer) {
        int userIntegerAnswer = integerTranslator(userIntialAnswer);
        int[] integerArray = new int[NUMBEROFBALL];

        for(int i = 0; i<NUMBEROFBALL; i++) {
            int singleNumber = userIntegerAnswer%10;
            zeroChecker(singleNumber);
            integerArray[NUMBEROFBALL-i-1] = singleNumber;
            userIntegerAnswer /= 10;
        }

        return integerArray;
    }

    private static int integerTranslator(String userInitialAnswer) {
        int integerAnswer;

        try {
            integerAnswer = Integer.parseInt(userInitialAnswer);
        } catch (Exception notIntegerType) {
            throw inputError;
        }

        return integerAnswer;
    }

    private static void zeroChecker(int singleNumber) {
        if (singleNumber == 0 ){
            throw inputError;
        }
    }
}
