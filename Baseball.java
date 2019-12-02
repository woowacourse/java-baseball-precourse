import java.util.*;
import java.util.stream.*;

public class Baseball {
    public static void main(String[] args) {
        String answer = threeDigitInteger();
        System.out.println(answer);
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
}