package baseball;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {

    private static final int NONE = -1;
    private static final int REPEAT = 1;
    private static final int END = 2;

    private Scanner scanner;
    private List<Integer> nums = new ArrayList<>();
    private boolean isRepeat = true;

    public boolean isRepeat() {
        return isRepeat;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }


    public void guess() {
        nums.clear();
        String inputStr = getInputStr();
        try {
            parseInputStrToNums(inputStr);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    private String getInputStr() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    private void parseInputStrToNums(String inputStr) {
        for (int i = 0; i < 3; i++) {
            nums.add(Integer.parseInt(inputStr.substring(i, i + 1)));
        }
    }


    public void updateRepeat() {
        int repeatInput = NONE;
        try {
            repeatInput = getRepeatInput();
        } catch (InputMismatchException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        parseIsRepeat(repeatInput);
    }

    private int getRepeatInput() {
        System.out.println("게임을 새로 시작하려면 " + REPEAT + ", 종료하려면 " + END + "를 입력하세요.");
        int repeatInput = scanner.nextInt();
        scanner.nextLine();
        return repeatInput;
    }

    private void parseIsRepeat(int repeatInput) {
        if (repeatInput == REPEAT)
            isRepeat = true;
        else if (repeatInput == END)
            isRepeat = false;
        else
            throw new IllegalArgumentException();
    }
}
