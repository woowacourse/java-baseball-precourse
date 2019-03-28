/*
 *BaseballGame.java
 *
 * 1.0.0
 *
 * 28/03/2019
 *
 * by KIM JUNG MIN
 *
 */

import java.util.*;

/**
 * BaseballGame class는 게임 전체를 정의하는 class입니다.
 * doGame() method를 정의하고 main을 통해서 게임을 실행합니다.
 */
public class BaseballGame {
    /**
     * BaseballGame의 main method입니다. main를 통해 게임을 실행합니다
     */
    public static void main(String[] args) {
        doGame();
    }

    /**
     * 게임을 직접 실행하는 doGame() method입니다.
     * 이 method는 재귀함수이며 user가 게임을 지속할 의지가 있으면
     * 재귀함수가 직동합니다.
     */
    public static void doGame() {
        String strComputerNumber = generateComputerNumber(); /*비교하기 편하게 computer number를 string으로 만든다*/
        while (true) {
            String strUserNumber = getUserNumber(); /*비교하기 편하게 user number를 string으로 만든다.*/
            int strikes = checkStrikes(strComputerNumber, strUserNumber); /*스트라이크 수 return.*/
            int balls = checkBalls(strComputerNumber, strUserNumber); /*볼 수 return*/
            if (strikes == 3 && balls == 0) {
                System.out.println("3 스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                break;
            } else if (strikes == 0 && balls == 0) {
                System.out.println("낫싱!");
            } else if (balls == 0) {
                System.out.println(strikes + " 스트라이크");
            } else if (strikes == 0) {
                System.out.println(balls + " 볼");
            } else {
                System.out.println(strikes + " 스트라이크 " + balls + " 볼");
            }
        }
        boolean wantOneMoreGame = getUserAnswer(); /*지속할 의향이 있을 시에 재귀함수가 작동합니다*/
        if (wantOneMoreGame) {
            doGame(); /*재귀함수*/
        }
    }

    /**
     * 컴퓨터의 숫자를 만드는 generateComputerNumber() method입니다.
     * 입력값은 없으며 retrun값은 세자리수의 String입니다.
     * String이 비교하기 쉽기 때문에 String을 활용합니다.
     *
     * @return 서로 다른 세숫자로 구성된 String. ex) "123"
     */
    public static String generateComputerNumber() {
        int result = 0;
        ArrayList<Integer> list = new ArrayList<Integer>(); /*random한 숫자를 뽑아내기 위해 array list를 만듭니다*/
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        int i = 0;
        int digit = 100; /*자릿수*/
        while (i < 3) {
            int index = (int) (Math.random() * list.size());
            result += list.get(index) * digit;
            list.remove(index);
            i++;
            digit /= 10;
        }
        String strResult = Integer.toString(result);
        return strResult;
    }

    /**
     * User의 input을 받은 getUserNumber() method입니다.
     * 입력값은 없으며 return 값은 세자리수의 String입니다.
     * String이 비교하기 쉽기 때문에 String을 활용합니다.
     *
     * @return 서로 다른 세숫자로 구성된 String. ex) "123"
     */
    public static String getUserNumber() {
        String strUserInput;
        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요: ");
            strUserInput = reader.nextLine();
            boolean isUserInputRight = checkUserInput(strUserInput); /*User의 input이 조건에 맞는지 확인합니다*/
            if (isUserInputRight) {
                break;
            }
        }
        return strUserInput;
    }

    /**
     * User의 input이 조건에 맞는지 확인하는 checkUserInput() method입니다.
     *
     * @param strUserInput User의 input이 parameter로 들어갑니다.
     * @return true or false.
     */
    public static boolean checkUserInput(String strUserInput) {
        if (strUserInput.length() != 3) {
            /*User의 input이 세자리수인지 확인*/
            System.out.println("서로 다른 세 숫자를 입력해 주세요!");
            return false;
        }
        if (isNonNumberThere(strUserInput)) {
            /*User의 input이 숫자로만 되어있는지 확인*/
            System.out.println("숫자만 입력가능합니다!");
            return false;
        }
        if (isZeroThere(strUserInput)) {
            /*User의 input에 0이 포함되어 있는지 확인*/
            System.out.println("숫자는 1~9까지만 입력해주세요!");
            return false;
        }
        //check repeating
        if (isRepeating(strUserInput)) {
            /*user의 input에 같은 숫자가 나오는지 확인.*/
            System.out.println("숫자는 모두 다른 숫자를 입력하십시오!");
            return false;
        }
        return true;
    }

    /**
     * User의 input이 숫자로만 이루어져 있는지 확인하는 isNonNumberThere() method입니다.
     *
     * @param strUserInput User의 input
     * @return true or false
     */
    public static boolean isNonNumberThere(String strUserInput) {
        for (int i = 0, n = strUserInput.length(); i < n; i++) {
            if (Character.isDigit(strUserInput.charAt(i))) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * User의 input에 0이 포함되어 있는지 확인하는 isZeroThere() method입니다.
     *
     * @param strUserInput User의 input
     * @return true or false
     */
    public static boolean isZeroThere(String strUserInput) {
        //0이 있는지 확인.
        for (int i = 0, n = strUserInput.length(); i < n; i++) {
            if (strUserInput.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    /**
     * User의 input에 같은 숫자가 있는지 확인하는 isRepeating() method입니다.
     *
     * @param strUserInput User의 input
     * @return true or false
     */
    public static boolean isRepeating(String strUserInput) {
        //중복하는 숫자가 있는지 확인.
        for (int i = 0, n = strUserInput.length(); i < n; i++) {
            String letter = String.valueOf(strUserInput.charAt(i));
            int count = strUserInput.length() - strUserInput.replace(letter, "").length();
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 스트라이크가 몇개 있는지 확인하는 checkStrikes() method입니다.
     *
     * @param strComputerNumber 컴퓨터가 생성한 숫자
     * @param strUserNumber     User의 input
     * @return 스트라이크의 갯수
     */
    public static int checkStrikes(String strComputerNumber, String strUserNumber) {
        //스트라이트 수를 확인한다.
        int count = 0;
        String combined = strComputerNumber + strUserNumber;
        for (int i = 0, n = combined.length(); i < n - 3; i++) {
            if (combined.charAt(i) == combined.charAt(i + 3)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 볼이 몇개 있는지 확인하는 checkBalls() method입니다.
     *
     * @param strComputerNumber 컴퓨터가 생성한 숫자
     * @param strUserNumber     User의 input
     * @return 볼의 갯수
     */
    public static int checkBalls(String strComputerNumber, String strUserNumber) {
        //볼 수를 확인한다.
        int count = 0;
        for (int i = 0, n = strComputerNumber.length(); i < n; i++) {
            int index = strUserNumber.indexOf(strComputerNumber.charAt(i));
            if (index != -1 && index != i) {
                count++;
            }
        }
        return count;
    }

    /**
     * User에게 게임을 계속할 의향이 있는지 물어보는 getUserAnswer() method입니다.
     * User가 계속 게임을 할 의향이 있으면 재귀함수가 작동합니다.
     *
     * @return true or false
     */
    public static boolean getUserAnswer() {
        boolean result;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String strUserInput = scanner.nextLine();
            if (strUserInput.length() == 1 && strUserInput.charAt(0) == '1') {
                result = true;
                break;
            } else if (strUserInput.length() == 1 && strUserInput.charAt(0) == '2') {
                result = false;
                break;
            } else {
                System.out.println("1이나 2를 입력해주세요!");
            }
        }
        return result;
    }
}