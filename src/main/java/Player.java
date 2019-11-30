import java.util.Scanner;

public class Player implements Entry {
    private static final int RANGE_MIN = 123;
    private static final int RANGE_MAX = 987;
    private int holdCount;
    private Scanner scanner;
    private Integer[] numbers;

    public Player(int holdCount) {
        this.holdCount = holdCount;
        this.numbers = new Integer[holdCount];
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Integer[] getNumbers() {
        return numbers;
    }

    private void setNumbers(String input) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) input.charAt(i) - '0';
        }
    }

    @Override
    public void resetNumbers() {
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
        for (int i = 0; i < holdCount; i++) {
            if (input.indexOf(input.charAt(i)) != i) {
                return true;
            }
        }

        return false;
    }

    private boolean hasZero(String input) {
        return input.contains("0");
    }

    @Override
    public void gameOver() {
        scanner.close();
    }
}
