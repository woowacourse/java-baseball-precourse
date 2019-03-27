package com.isbee.game.baseball;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * 플레이어의 입력을 처리하는 BaseballInput 구현 클래스
 *
 * @author isbee
 * @version 1.0
 */
public class UserInput implements BaseballInput {

    private final Scanner scanner;
    private final Pattern strPattern;
    private int digitNum;

    public UserInput(int digitNum) {
        scanner = new Scanner(System.in);
        strPattern = Pattern.compile("\\D");
        this.digitNum = digitNum;
    }

    /** 사용자의 숫자를 입력받은 뒤, 올바른 입력값인지 검증한다
     *
     * @return 입력된 숫자
     * */
    @Override
    public int getUserNum() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = strPattern.matcher(scanner.nextLine()).replaceAll("");     // 숫자만 확인하기 위한 전처리
            if (validateDigitNum(input) && validateDuplicate(input)) {
                return Integer.parseInt(input);
            }
            System.out.print("\n잘못된 입력입니다. 입력값은 1~9 사이의 서로 다른 숫자로 이루어진 " + digitNum + "자리 숫자여야 합니다.\n");
        }
    }

    /** 재시작 여부를 입력 받은 뒤, 올바른 입력값인지 검증한다.
     *
     * @return 입력된 숫자
     * */
    @Override
    public int getWhetherRestart() {
        while (true) {
            String input = strPattern.matcher(scanner.nextLine()).replaceAll("");
            if (validateDigitNum(input, 1) && validateOneOrTwo(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("\n잘못된 입력입니다. 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        }
    }

    private boolean validateDigitNum(String input) {
        return input.length() == digitNum;
    }

    private boolean validateDigitNum(String input, int len) {
        return input.length() == len;
    }

    private boolean validateOneOrTwo(String input) {
        int num = input.charAt(0) - '0';

        return (num == Instruction.RESTART.getNum()) || (num == Instruction.STOP.getNum());
    }

    private boolean validateDuplicate(String input) {
        boolean check[] = new boolean[10];
        Arrays.fill(check, false);

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            if (check[num]) {
                return false;
            }
            check[num] = true;
        }
        return true;
    }

    public boolean playMoreOrNot() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getWhetherRestart() == Instruction.RESTART.getNum();
    }

    /**
     * 입력값의 의도를 정의하기 위한 Enum
     */
    private enum Instruction {

        RESTART(1), STOP(2);

        private int num;

        Instruction(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}