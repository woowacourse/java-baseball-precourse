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
        System.out.println(scannerNumber);
    }
}
