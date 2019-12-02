import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {

    private Client client = new Client();

    @Test
    void check_length() {
        /* when & then: 길이가 3이 아닌 문자열을 입력 받으면 예외 발생 */
        assertThrows(RuntimeException.class, () -> client.makeNumbersFromString("1234"));
    }

    @Test
    void check_allNumbers() {
        /* when & then: 숫자가 아닌 문자가 포함된 문자열을 입력 받으면 예외 발생 */
        assertThrows(RuntimeException.class, () -> client.makeNumbersFromString("1k2"));
    }

    @Test
    void check_noZero() {
        /* when & then: 0이 포함된 숫자를 입력 받으면 예외 발생 */
        assertThrows(RuntimeException.class, () -> client.makeNumbersFromString("023"));
    }

    @Test
    void check_noDuplication() {
        /* when & then: 중복된 숫자를 입력 받으면 예외 발생 */
        assertThrows(RuntimeException.class, () -> client.makeNumbersFromString("223"));
    }

    @Test
    void convertToAnswer_FromInputString() {
        /* given: client 객체에서 */
        Client client = new Client();

        /* when: "387"을 입력 받으면 */
        List<Integer> madeNumbersFromString = client.makeNumbersFromString("387");

        /* then: 3, 8, 7을 가지고 있는 리스트 생성 */
        List<Integer> listToCompare = new ArrayList<>();
        listToCompare.add(3);
        listToCompare.add(8);
        listToCompare.add(7);

        assertTrue(madeNumbersFromString.equals(listToCompare));
    }
}