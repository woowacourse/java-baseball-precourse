/**
 * java-baseball-precourse
 * InputUtils.java
 * Purpose: 숫자 야구 게임에 필요한 입력방식을 구현함.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */
package utils;

import java.util.Scanner;

public class InputUtils {
    public static final String INVALID = "유효하지 않은 입력입니다.";
    static Scanner scanner = new Scanner(System.in);

    /**
     * 요구된 숫자야구 전반은 숫자가 입력된다. 이를 처리하기위한 Method.
     *
     * @param prompt 전달받은 prompt를 출력하고 입력을 받는다.
     * @return Integer 변환한 입력.
     */
    public static Integer inputInteger(String prompt) {
        Integer input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(INVALID);
                flush(scanner);
            }
        }
        flush(scanner);
        return input;
    }

    /**
     * scanner의 버퍼를 비운다.
     *
     * @param scanner
     */
    public static void flush(Scanner scanner) {
        scanner.nextLine();
    }

    /**
     * 프로그램 종료시 scanner를 닫는다.
     */
    public static void closeInput() {
        scanner.close();
    }
}
