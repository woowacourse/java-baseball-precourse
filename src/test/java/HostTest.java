import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class HostTest {

    private boolean checkNumberBetweenOneAndNine(List<Integer> numbers) {
        boolean allBetweenOneAndNine = true;
        for (Integer number : numbers) {
            if ( !(1 <= number && number <= 9) ) {
                allBetweenOneAndNine = false;
                break;
            }
        }
        return allBetweenOneAndNine;
    }

    private boolean checkNoDuplication(List<Integer> numbers) {
        boolean NoDuplication = true;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    NoDuplication = false;
                }
            }
        }
        return NoDuplication;
    }

    @Test
    void generate_baseball_numbers() {

        Host host = new Host();

        /* when: host의 generateNumbers 메서드를 실행하면 */
        host.generateNumbers();
        List<Integer> numbers = host.getNumbers();

        /* then: numbers에 중복되지 않은 1에서 9까지의 숫자가 생성된다 */
        Assertions.assertTrue(checkNumberBetweenOneAndNine(numbers));
        Assertions.assertTrue(checkNoDuplication(numbers));
        Assertions.assertTrue(numbers.size() == Host.baseballGameSize);

    }
}