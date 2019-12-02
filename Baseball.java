import java.util.*;
import java.util.stream.*;

public class Baseball {
    public static void main(String[] args) {
        boolean newGame = true;
        while (newGame) {
            oneRound();
            newGame = renewOrQuit();
        }
    }

    private static boolean renewOrQuit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            return true;
        }
        return false;
    }

    private static void oneRound() {
        boolean threeStrikes = false;
        String answer = threeDigitInteger();
        System.out.println("정답: " + answer);
        while(!threeStrikes) {
            threeStrikes = guessAndCheck(answer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private static boolean guessAndCheck(String answer) {
        String guess = userGuess();
        while (!isValid(guess)) {
            guess = userGuess();
        }
        return checkGuess(answer, guess);
    }

    private static boolean checkGuess(String answer, String guess) {
        int strikeCount = countStrikes(answer, guess);
        int ballCount = countBalls(answer, guess);
        String result = formatResult(strikeCount, ballCount);
        System.out.println(result);
        return strikeCount == 3;
    }

    private static String threeDigitInteger() {
        // 1부터 9까지의 정수 리스트 만들기
        List<Integer> digits = allowedDigits();
        // 9개의 정수를 임의로 순서 바꾸기
        Collections.shuffle(digits);
        // 9개 정수 중 앞의 3개만 가져오기
        List<Integer> threeDigits = digits.subList(0, 3);
        // 3개의 정수로 이루어진 리스트를 하나의 스트링으로 바꾸기
        return toDigitString(threeDigits);
    }

    private static List<Integer> allowedDigits() {
        List<Integer> digits =
                IntStream.range(1, 10)
                        .boxed()
                        .collect(Collectors.toList());
        return digits;
    }

    private static String toDigitString(List<Integer> digits) {
        String digitString = "";
        for (Integer digit : digits) {
            digitString += digit;
        }
        return digitString;
    }

    private static String userGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    private static boolean isValid(String guess) {
        // 1. 3개의 문자로 이루어진 문자열임
        if (guess.length() != 3) {
            System.out.println("3자리의 수만 입력 가능합니다.");
            return false;
        }
        // 2. 모든 문자가 1부터 9사이의 숫자임
        if (!allValidDigits(guess)) {
            System.out.println("1부터 9까지의 숫자만 입력 가능합니다.");
            return false;
        }
        // 3. 중복되는 숫자가 없음
        if (hasDuplicates(guess)) {
            System.out.println("숫자가 중복되면 안됩니다.");
            return false;
        }
        return true;
    }

    private static boolean isValidDigit(char digit) {
        String allowedDigits = toDigitString(allowedDigits());
        return allowedDigits.indexOf(digit) >= 0;
    }

    private static boolean allValidDigits(String guess) {
        for (char digit : guess.toCharArray()) {
            if (!isValidDigit(digit)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicates(String guess) {
        Set<String> lump = new HashSet<String>();
        for (char digit : guess.toCharArray()) {
            String digitString = Character.toString(digit);
            if (lump.contains(digitString)) {
                return true;
            }
            lump.add(digitString);
        }
        return false;
    }

    private static int countStrikes(String answer, String guess) {
        assert isValid(answer) : "Invalid answer";
        assert isValid(guess) : "Invalid guess";
        char[] answerArray = answer.toCharArray();
        char[] guessArray = guess.toCharArray();

        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] == guessArray[i]) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private static int countBalls(String answer, String guess) {
        assert isValid(answer) : "Invalid answer";
        assert isValid(guess) : "Invalid guess";
        char[] answerArray = answer.toCharArray();
        char[] guessArray = guess.toCharArray();

        List<Integer> ballIndices = findBalls(answer, guess);
        int ballCount = 0;
        for (int ballIndex : ballIndices) {
            ballCount += within(answer, guessArray[ballIndex]);
        }
        return ballCount;
    }

    private static int within(String answer, char digit) {
        if (answer.indexOf(digit) >= 0) {
            return 1;
        }
        return 0;
    }

    private static List<Integer> findBalls(String answer, String guess) {
        assert isValid(answer) : "Invalid answer";
        assert isValid(guess) : "Invalid guess";
        char[] answerArray = answer.toCharArray();
        char[] guessArray = guess.toCharArray();

        List<Integer> ballIndices = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] != guessArray[i]) {
                ballIndices.add(i);
            }
        }
        return ballIndices;
    }

    private static String formatResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        if (strikeCount == 0) {
            return ballCount + "볼";
        }
        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        return strikeCount + "스트라이크" + " " + ballCount + "볼";
    }
}