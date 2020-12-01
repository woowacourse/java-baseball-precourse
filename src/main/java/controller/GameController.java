package controller;

import com.sun.tools.jdeprscan.scan.Scan;
import ganerator.NumberGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    private static String scannerNumber = new String();

    /**
     * 게임을 시작하는 메소드
     */
    public static void start(Scanner scanner) {
        System.out.print("숫자를 입력주세요 : ");
        scanNumber(scanner);
        System.out.println("결과"); //테스트용
    }

    /**
     * 3자리수를 입력받는 메소드
     */
    public static void scanNumber(Scanner scanner) {
        scannerNumber = scanner.nextLine();
        isValidateNumber(scannerNumber);
    }

    /**
     * 입력받은 값이 정상적인 입력인지 검증하는 메소드
     */
    public static void isValidateNumber(String scannerNumber) {
        //3자리가 아닌 입력인 경우 ex)1234
        if (scannerNumber.length() != 3) {
            throw new IllegalArgumentException("3자릿수를 입력해주세요.");
        }
        //1~9 이외의 문자가 입력되는 경우 ex)0, a
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(scannerNumber.charAt(i)) || scannerNumber.charAt(i) == '0') {
                throw new IllegalArgumentException("1~9사이의 숫자를 입력해주세요.");
            }
        }
        //중복된 숫자가 입력되는 경우 ex)122, 454
        if (isDuplicateNumber(scannerNumber)) {
            throw new IllegalArgumentException("동일한 숫자는 입력할 수 없습니다.");
        }
    }

    public static boolean isDuplicateNumber(String scannerNumber) {
        if (scannerNumber.charAt(0) == scannerNumber.charAt(1)
                || scannerNumber.charAt(1) == scannerNumber.charAt(2)
                || scannerNumber.charAt(2) == scannerNumber.charAt(0)) {
            return true;
        }
        return false;
    }
}
