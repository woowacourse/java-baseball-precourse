import java.util.*;
import java.util.stream.*;

public class Baseball {
    public static void main(String[] args) {
        boolean newGame = true;
        while (newGame) {
            playOneRound();
            newGame = makeValidChoice();
        }
    }

    private static void playOneRound() {
        boolean threeStrikes = false;
        String answer = randomThreeDigits();
        while(!threeStrikes) {
            String guess = makeValidGuess(answer);
            threeStrikes = compareDigits(answer, guess);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private static String inputChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }

    private static boolean makeValidChoice() {
        String choice = inputChoice();
        while (!isValidChoice(choice)) {
            System.out.println("1과 2중에 선택해주세요.");
            choice = inputChoice();
        }
        return choice.equals("1");
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("1") || choice.equals("2");
    }

    private static String inputGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    private static String makeValidGuess(String answer) {
        String guess = inputGuess();
        while (!isValidNum(guess)) {
            guess = inputGuess();
        }
        return guess;
    }

    private static boolean isValidNum(String guess) {

        // 조건 1. 3개의 문자로 이루어진 문자열임
        if (guess.length() != 3) {
            System.out.println("3자리의 수만 입력 가능합니다.");
            return false;
        }

        // 조건 2. 모든 문자가 1부터 9사이의 숫자임
        if (!allValidDigits(guess)) {
            System.out.println("1부터 9까지의 숫자만 입력 가능합니다.");
            return false;
        }

        // 조건 3. 중복되는 숫자가 없음
        if (hasDuplicates(guess)) {
            System.out.println("숫자가 중복되면 안됩니다.");
            return false;
        }
        return true;
    }

    private static boolean isValidDigit(char digit) {
        String allowedDigits = listToString(allowedDigits());
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

        // set은 중복된 원소가 없다는 사실을 이용해 중복된 숫자가 있는지 알아내기
        Set<String> lump = new HashSet<String>();
        for (char digit : guess.toCharArray()) {
            String digitString = Character.toString(digit);

            // digit이 set에 있으면, 중복임
            if (lump.contains(digitString)) {
                return true;
            }

            // digit이 set에 없으면, set에 추가함
            lump.add(digitString);
        }
        return false;
    }

    private static String randomThreeDigits() {

        // 1부터 9까지의 정수 리스트 만들기
        List<Integer> digits = allowedDigits();

        // 9개의 정수를 임의로 순서 바꾸기
        Collections.shuffle(digits);

        // 9개 정수 중 앞의 3개만 가져오기
        List<Integer> threeDigits = digits.subList(0, 3);

        // 3개의 정수로 이루어진 리스트를 하나의 스트링으로 바꾸기
        return listToString(threeDigits);
    }

    private static List<Integer> allowedDigits() {
        List<Integer> digits =
                IntStream.range(1, 10)                     // 허용된 digit: 1 ~ 9
                         .boxed()                          // int -> Integer
                         .collect(Collectors.toList());    // 모든 값을 리스트로 모으기
        return digits;
    }

    private static String listToString(List<Integer> digits) {
        String digitString = "";
        for (Integer digit : digits) {
            digitString += digit;
        }
        return digitString;
    }

    private static boolean compareDigits(String answer, String guess) {
        int strikeCount = countStrikes(answer, guess);
        int ballCount = countBalls(answer, guess);
        showResult(strikeCount, ballCount);
        return strikeCount == 3;
    }

    private static int countStrikes(String answer, String guess) {
        assert isValidNum(answer) : "Invalid answer";
        assert isValidNum(guess) : "Invalid guess";

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
        assert isValidNum(answer) : "Invalid answer";
        assert isValidNum(guess) : "Invalid guess";

        char[] guessArray = guess.toCharArray();

        List<Integer> potentialBalls = findNonStrikes(answer, guess);
        int ballCount = 0;
        for (int potentialBall : potentialBalls) {
            ballCount += within(answer, guessArray[potentialBall]);
        }
        return ballCount;
    }

    private static List<Integer> findNonStrikes(String answer, String guess) {
        assert isValidNum(answer) : "Invalid answer";
        assert isValidNum(guess) : "Invalid guess";

        char[] answerArray = answer.toCharArray();
        char[] guessArray = guess.toCharArray();

        // 스트라이크가 아닌 자리의 index를 리스트에 추가하기
        List<Integer> potentialBalls = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] != guessArray[i]) {
                potentialBalls.add(i);
            }
        }
        return potentialBalls;
    }

    private static int within(String answer, char digit) {
        if (answer.indexOf(digit) >= 0) {
            return 1;
        }
        return 0;
    }

    private static String formatResult(int strikeCount, int ballCount) {
        if ((strikeCount == 0) && (ballCount == 0)) {
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

    private static void showResult(int strikeCount, int ballCount) {
        String result = formatResult(strikeCount, ballCount);
        System.out.println(result);
    }
}