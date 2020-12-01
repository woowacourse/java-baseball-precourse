package controller;

import ganerator.NumberGenerator;

import java.util.Scanner;

/** 숫자야구게임의 로직을 담당하는 클래스*/
public class GameController {
    private static String scannerNumber = new String(); //플레이어의 입력을 받는 문자열
    private static int[] targetNumber = new int[3]; //정답번호를 저장하는 배열
    private static int[] inputNumber = new int[3]; //정상적인 입력이라고 확인된 번호를 저장하는 배열
    private static int strike, ball;

    /**
     * 게임을 시작하는 메소드
     */
    public static void start(Scanner scanner) {
        //타겟넘버 생성
        NumberGenerator numberGenerator = new NumberGenerator();
        targetNumber = numberGenerator.generatorNewNumber();

//        System.out.print("정답: ");
//        for (int i = 0; i < 3; i++) {
//            System.out.print(targetNumber[i]); //정답 테스트용
//        }
//        System.out.println();

        boolean finish = false;
        while (!finish) {
            System.out.print("숫자를 입력주세요 : ");
            scanNumber(scanner);
            strike = ball = 0;
            countStrike(); //스트라이크 카운트하는 메소드 호출
            countBall(); //볼 카운트하는 메소드 호출
            if (ball > 0) {
                System.out.println(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.println(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            }
            if (strike == 3) {
                System.out.println("3 개의 숫자를 모두 맞히셨습니다! 게임 종료");
                finish = true; //while문 종료조건
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        askToRestart(scanner); //재시작 판단 메소드 호출
    }

    /**
     * 스트라이크 개수를 카운팅하는 메소드
     */
    public static void countStrike() {
        for (int i = 0; i < 3; i++) {
            if(targetNumber[i] == inputNumber[i]) strike++;
        }
    }

    /**
     * 볼의 개수를 카운팅하는 메소드
     */
    public static void countBall() {
        if(targetNumber[0] == inputNumber[1] || targetNumber[0] == inputNumber[2]) ball++;
        if(targetNumber[1] == inputNumber[2] || targetNumber[1] == inputNumber[0]) ball++;
        if(targetNumber[2] == inputNumber[0] || targetNumber[2] == inputNumber[1]) ball++;
    }

    /**
     * 3자리수를 입력받는 메소드
     */
    public static void scanNumber(Scanner scanner) {
        scannerNumber = scanner.nextLine();
        validateNumber(scannerNumber);
        convertNumber(scannerNumber); //정상입력일 때 문자열->배열 변환 수행
    }

    /**
     * 입력받은 값이 정상적인 입력인지 검증하는 메소드
     */
    public static void validateNumber(String scannerNumber) {
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

    /**
     * 중복된 숫자가 입력되는지 여부를 반환하는 메소드
     *
     * @param scannerNumber
     * @return
     */
    public static boolean isDuplicateNumber(String scannerNumber) {
        if (scannerNumber.charAt(0) == scannerNumber.charAt(1)
                || scannerNumber.charAt(1) == scannerNumber.charAt(2)
                || scannerNumber.charAt(2) == scannerNumber.charAt(0)) {
            return true;
        }
        return false;
    }

    /**
     * 정상입력된 문자열을 정수형 배열로 변환하는 메소드
     *
     * @param scannerNumber
     */
    public static void convertNumber(String scannerNumber) {
        for (int i = 0; i < 3; i++) {
            //각 숫자를 배열에 대입
            inputNumber[i] = Integer.valueOf(scannerNumber.charAt(i)) - '0';
        }
    }

    /**
     * 게임 종료 후 새로 입력받아 새로시작(1) or 종료(2)을 수행하는 메소드
     * @param scanner
     * @return
     */
    public static void askToRestart(Scanner scanner) {
        String input = scanner.nextLine();
        //다시 시작
        if (input.equals("1")) {
            start(scanner);
        } else if (!input.equals("2")) { //잘못된 입력인 경우
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
    }
}
