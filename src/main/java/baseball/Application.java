package baseball;

import java.util.Scanner;
import utils.RandomUtils;

/*
 *              숫자 야구 게임을 진행하는 클래스
 * @author      483759/윤이진
 * */
public class Application {

    private static final int INPUT_NUM = 3; //숫자 야구의 자릿수를 저장하는 변수

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int menu = 0;

        while (menu != 2) {
            menu=0;
            startGame(scanner);
            while (menu!=1&&menu!=2) {
                menu = selectMenu(scanner);
            }
        }
    }

    /* 전반적인 게임 진행을 담당하는 메소드 */
    public static void startGame(Scanner scanner) {
        String inputValue = null;
        String matchValue = "";
        Number comNum = setComputerNumber();
        Number usrNum;

        while (!matchValue.equals(INPUT_NUM+"스트라이크")) {
            boolean correctValue = false;
            while (!correctValue) {
                printNumberInput();
                inputValue = getUserInput(scanner);
                correctValue = isValidInput(inputValue);
            }
            usrNum = setUserNumber(inputValue);
            matchValue = countBallsAndStrikes(comNum, usrNum);
            System.out.println(matchValue);
        }
        System.out.println(INPUT_NUM+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
        scanner.nextLine();
    }

    /* 게임이 종료된 뒤, 재시작 혹은 종료를 선택하는 함수 */
    public static int selectMenu(Scanner scanner) {
        int menuNum = 0;
        System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        try {
            menuNum=Integer.parseInt(scanner.nextLine());
            if (menuNum != 1 && menuNum != 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("1또는 2를 입력하세요");
        }

        return menuNum;
    }

    /* 컴퓨터의 숫자값을 랜덤하게 생성하여 Number객체를 반환하는 메서드 */
    public static Number setComputerNumber() {
        Number comNum = new Number(INPUT_NUM);
        for (int i = 0; i < INPUT_NUM; i++) {
            int randomNum = RandomUtils.nextInt(0, 9);
            while (comNum.isUsedNumber(randomNum)) {
                randomNum = RandomUtils.nextInt(0, 9);
            }
            comNum.setNumberAt(i, randomNum);
        }
        return comNum;
    }

    /* 입력된 input값을 userNumber로 변환하는 메서드 */
    public static Number setUserNumber(String inputValue) {
        Number usrNum = new Number(INPUT_NUM);
        for (int i = 0; i < INPUT_NUM; i++) {
            int number = Character.getNumericValue(inputValue.charAt(i));
            usrNum.setNumberAt(i, number);
        }
        return usrNum;
    }

    /* 게임 진행을 위해 숫자를 입력하라는 안내를 출력하는 메소드 */
    public static void printNumberInput() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    /* 유저에게 숫자를 입력받아 반환하는 메소드 */
    public static String getUserInput(Scanner scanner) {
        String inputValue = scanner.next();
        return inputValue;
    }

    /* 유저가 입력한 숫자가 올바른 형식인지 검사하는 메소드 */
    public static boolean isValidInput(String inputValue) {
        boolean isValid = true;

        try {
            if (inputValue.length() != INPUT_NUM) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < inputValue.length(); i++) {
                // 개별 문자에 대해 형식이 맞는지 검사
                isValid &= isValidCharacter(inputValue.charAt(i));
                isValid &= isRedundantInput(inputValue, i);
            }
            if (isValid == false) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_NUM+"자리 숫자를 중복없이 입력해 주세요!");
            return false;
        }
        return isValid;
    }

    /* 해당 문자가 입력 요구사항에 일치하는지 검사하는 메소드 */
    public static boolean isValidCharacter(char inputCharacter) {
        try {
            if (inputCharacter < '1' || inputCharacter > '9') {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("1과 9 사이의 숫자를 입력해 주세요!");
            return false;
        }
        return true;
    }

    /* index에 위치한 Chracter가 이전에 등장한 적이 있는지 검사하는 메서드 */
    public static boolean isRedundantInput(String inputValue, int index) {
        if (inputValue.length() <= index) {
            return true;
        }
        for (int i = 0; i < index; i++) {
            if (inputValue.charAt(i) == inputValue.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    /* computer와 user가 입력한 세 자리 숫자의 점수를 계산하는 메서드 */
    public static String countBallsAndStrikes(Number comNum, Number usrNum) {
        int strike = 0, ball = 0;
        for (int i = 0; i < INPUT_NUM; i++) {
            int number = usrNum.getNumberAt(i);

            int index = comNum.findNumber(number);
            if (index == i) {
                strike++;
            } else if (index >= 0) {
                ball++;
            }
        }

        return printGameResult(ball, strike);
    }

    /* 볼과 스트라이크 개수로 사용자에게 보여질 출력 결과를 반환하는 메서드 */
    public static String printGameResult(int ball, int strike){
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }

}
