import java.util.Scanner;

public class Player {
    private static final int RANGE_MIN = 123;
    private static final int RANGE_MAX = 987;
    private static final int HOLD_COUNT = 3;
    private Scanner scanner;
    private Integer[] numbers;

    public Player() {
        this.numbers = new Integer[HOLD_COUNT];
        this.scanner = new Scanner(System.in);
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    private void setNumbers(String input) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) input.charAt(i) - '0';
        }
    }

    public void receiveNumbers() {
        System.out.println("1~9 사이의 서로 다른 세자리 숫자를 입력해주세요.");

        while (true) {
            String input = scanner.nextLine();

            if (isNumberInRange(input) && !hasDuplicate(input) && !hasZero(input)) {
                setNumbers(input);
                break;
            } else {
                System.out.println("1~9 사이의 서로 다른 세자리 숫자를 입력해야 합니다. 다시 입력해주세요.");
            }
        }

        scanner.close();
    }

    private boolean isNumberInRange(String input) {
        try {
            int inputNumber = Integer.parseInt(input);
            return (inputNumber >= RANGE_MIN) && (inputNumber <= RANGE_MAX);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean hasDuplicate(String input) {
        for (int i = 0; i < HOLD_COUNT; i++) {
            if (input.indexOf(input.charAt(i)) != i) {
                return true;
            }
        }

        return false;
    }

    private boolean hasZero(String input) {
        return input.contains("0");
    }

    public void gameOver() {
        scanner.close();
    }
}
