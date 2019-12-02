import java.util.*;

public class Main {
    private static final int MAX_NUMBER = 9;
    private static final int MAX_ARRAY_SIZE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = createNumbers();

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            int guess = scanner.nextInt();

            if (isGuessValid(guess, numbers)) {
                break;
            }
        }
    }

    private static List<Integer> createNumbers() {
        long seed = System.currentTimeMillis();
        Random rand = new Random(seed);

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            int temp = rand.nextInt(MAX_NUMBER) + 1;

            if (!isNumberUnique(temp, numbers)) {
                i--;

                continue;
            }

            numbers.add(temp);
        }

        return numbers;
    }

    private static boolean isNumberUnique(int temp, List<Integer> numbers) {
        boolean flag = true;

        for (Integer number : numbers) {
            if (temp == number) {
                flag = false;

                break;
            }
        }

        return flag;
    }

    private static List<Integer> createGuesses(int guess) {
        List<Integer> guesses = new ArrayList<>();
        Stack<Integer> tempStack = new Stack<>();

        while (guess != 0) {
            tempStack.push(guess % 10);

            guess /= 10;
        }

        while (!tempStack.empty()) {
            guesses.add(tempStack.peek());

            tempStack.pop();
        }

        return guesses;
    }

    private static boolean isGuessValid(int guess, List<Integer> numbers) {
        List<Integer> guesses = createGuesses(guess);

        if (guesses.size() != MAX_ARRAY_SIZE) {
            System.out.println("3자리 숫자를 입력하셔야 합니다. 다시 입력해주세요");

            return false;
        }

        int strikes = getStrikes(guesses, numbers);
        int balls = getBalls(guesses, numbers);

        if (strikes == MAX_ARRAY_SIZE) {
            System.out.println("3 스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return true;
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");

            return false;
        }

        System.out.println(strikes + "스트라이크 " + balls + "볼");

        return false;
    }

    private static int getStrikes(List<Integer> guesses, List<Integer> numbers) {
        int strikes = 0;

        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (guesses.get(i) == numbers.get(i)) {
                strikes++;
            }
        }

        return strikes;
    }

    private static boolean isGuessBall(int index, List<Integer> guesses, List<Integer> numbers) {
        int guess = guesses.get(index);

        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (i == index) {
                continue;
            }

            if (numbers.get(i) == guess) {
                return true;
            }
        }

        return false;
    }

    private static int getBalls(List<Integer> guesses, List<Integer> numbers) {
        int balls = 0;

        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (isGuessBall(i, guesses, numbers)) {
                balls++;
            }
        }

        return balls;
    }
}
