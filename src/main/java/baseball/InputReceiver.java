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
            System.out.println("3자리가 초과하였습니다.");
            throw inputError;
        }

        if (userInitialAnswer.length()<3){
            System.out.println("3자리 미만입니다.");
            throw inputError;
        }
    }

    private static int[] intergerArrayTranslator(String userIntialAnswer) {
        int userIntegerAnswer = integerTranslator(userIntialAnswer);
        int[] integerArray = new int[NUMBEROFBALL];

        for(int position = 0; position<NUMBEROFBALL; position++) {
            int singleNumber = userIntegerAnswer%10;
            zeroChecker(singleNumber);
            integerArray[NUMBEROFBALL-position-1] = singleNumber;
            userIntegerAnswer /= 10;
        }

        overlappedChecker(integerArray);
        return integerArray;
    }

    private static int integerTranslator(String userInitialAnswer) {
        int integerAnswer;

        try {
            integerAnswer = Integer.parseInt(userInitialAnswer);
        } catch (Exception notIntegerType) {
            System.out.println("입력값은 정수여야만 합니다.");
            throw inputError;
        }

        return integerAnswer;
    }

    private static void zeroChecker(int singleNumber) {
        if (singleNumber == 0 ){
            System.out.println("0이외의 1~9자리로 구성된 숫자를 입력해주세요");
            throw inputError;
        }
    }

    private static void overlappedChecker(int[] integerArray) {
        for(int turn = 0; turn<NUMBEROFBALL; turn++) {
            comparedOne(integerArray, turn);
        }
    }

    private static void comparedOne(int[] integerArray, int turn) {
        for (int j = turn+1; j<NUMBEROFBALL; j++) {
            if (integerArray[turn] == integerArray[j]) {
                System.out.println("중복된 자리 수들을 입력하셨습니다");
                throw inputError;
            }
        }
    }

    public static boolean askEndGames() {
        String criteria = receiver.nextLine();
        if (criteria.equals("1")) {
            return false;
        }

        if (criteria.equals("2")) {
            return true;
        }

        System.out.println("유효하지 못한 입력입니다.");
        throw inputError;
    }
}
