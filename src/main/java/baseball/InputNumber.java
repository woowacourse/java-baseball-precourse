package baseball;

import java.util.Scanner;

public class InputNumber {
    public static final String WARNING_MESSAGE = "1에서 9까지 서로 다른 임의의 수 3개를 입력해 주세요: ";

    public static String getInput(Scanner scanner) {
        try {
            System.out.print(WARNING_MESSAGE);
            String inputNumber = scanner.next();
            if (validateInput(inputNumber)) {
                return inputNumber;
            }
        } catch (IllegalArgumentException e) {
            return getInput(scanner);
        }
        return "";
    }

    //입력값의 유효성 검사
    public static boolean validateInput(String inputNumber) throws IllegalArgumentException {
        //3자리가 아니면 예외를 발생시킨다
        if (inputNumber.length() != Application.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        //중복된 숫자가 있어도 예외를 발생시킨다
        if (duplicateExist(inputNumber)) {
            throw new IllegalArgumentException();
        }
        //문자열을 입력하면 예외를 발생시킨다
        for (int i =0; i < inputNumber.length(); i++) {
            if (!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    //중복된 숫자가 있는지 확인하는 함수
    public static boolean duplicateExist(String inputNumber) {
        int[] numberArray = new int[10];
        for (int i=0; i < inputNumber.length(); i++) {
            //i번째 char형 숫자를 int형으로 변환
            int ithInt = Character.getNumericValue(inputNumber.charAt(i));
            numberArray[ithInt] += 1;
            //이미 다른 숫자가 기록된 적 있다면 중복이므로 true를 반환한다
            if (numberArray[ithInt] > 1) {
                return true;
            }
        }
        return false;
    }
}