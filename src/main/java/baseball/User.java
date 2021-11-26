package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String input;
    public static int nextRound;
    public static int[] userNumber;

    // 사용자가 입력한 3개의 수를 정수 배열로 저장 후 반환
    public static int[] inputNumber() {

        input = Console.readLine();

        // 유저 입력에 0이 포함된 경우
        if(input.contains("0")) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        // 유저 입력이 3자리가 아닌 경우
        if(input.length() != 3) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        // 유저 입력에 문자가 포함된 경우
        for(int i=0; i<3; i++) {
            checkNumeric(input.charAt(i));
        }

        userNumber = stringToInt(input);

        return userNumber;
    }

    public static void checkNumeric(char c) {
        if(!Character.isDigit(c)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    // 입력받은 수를 String 에서 int array 로 저장
    public static int[] stringToInt(String inputNumber) {
        int[] number = new int[3];

        for(int i=0; i<3; i++) {
            number[i] = Character.getNumericValue(inputNumber.charAt(i));
        }

        return number;
    }

    public static int choiceNextRound() {
        nextRound = Integer.parseInt(Console.readLine());
        return nextRound;
    }
}
