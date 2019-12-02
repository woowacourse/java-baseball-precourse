import java.util.*;
import java.util.stream.*;

public class Baseball {
    public static void main(String[] args) {
        String answer = threeDigitInteger();
        String guess = userGuess();
        while (!isValid(guess)) {
            guess = userGuess();
        }
        int strikeCount = countStrikes(answer, guess);
        System.out.println(strikeCount + "스트라이크");
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
}