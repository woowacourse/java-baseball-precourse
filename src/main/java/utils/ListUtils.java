package utils;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    private ListUtils() {
    }

    public static List<Integer> intToDigitsList (int number) {
        return Integer.toString(number).chars().map(c -> c-'0')
                .boxed().collect(Collectors.toList());
    }
}
