import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballGame {
    private static final Integer[] TARGET_INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //__더 좋은 방법이 있을지 모르겠음
    private static final int numberLength = 3;

    public static void main(String[] args) {
        System.out.println("숫자를 입력해주세요 ");
        List<Integer> computerNumber = generateComputerNumber();
        System.out.println(computerNumber);
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> integerList = Arrays.asList(TARGET_INTEGERS);
        Collections.shuffle(integerList);
        List<Integer> slicedList = integerList.subList(0, numberLength);
        return slicedList;
    }
}
