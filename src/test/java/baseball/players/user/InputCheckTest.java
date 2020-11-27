package baseball.players.user;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.players.User;
import baseball.players.numbers.UserNumbers;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputCheckTest {
    private User user;
    private final UserNumbers userNumbers = new UserNumbers();
    // 올바른 입력
    private final String[] correctUserInputs = {"123\n", "329\n", "912\n", "813\n"};
    // 세 자리가 아닌 입력, 0이 포함된 숫자, 중복된 수가 있는 입력
    private final String[] notCorrectOnlyNumbers = {"1\n", "12\n", "1234\n", "120\n", "122\n"};
    // 세 자리가 아닌 입력, 1~9 이외의 문자 포함
    private final String[] notCorrectWitNotNumbers
        = {"\n", " \n", "\t\n", "1 3\n", "3k5\n", "1\n", "3\t6\n"};

    @DisplayName("올바른 입력 조건 검사 통과")
    @Test
    void correctInputValidation() {
        for (String input : correctUserInputs) {
            assertDoesNotThrow(() -> {
                user = new User(new Scanner(input));
                user.userInput();
            });
            userNumbers.clear();
        }
    }

    @DisplayName("세 자리가 아닌 입력, 0이 포함된 숫자, 중복된 수가 있는 입력 에러")
    @Test
    void notCorrectOnlyNumbersValidation() {
        for (String input : notCorrectOnlyNumbers) {
            assertThrows(IllegalArgumentException.class, () -> {
                user = new User(new Scanner(input));
                user.userInput();
            });
            userNumbers.clear();
        }
    }

    @DisplayName("숫자이외의 문자입력이 있으면 리스트 변환시 IllegalArgumentException이 발생한다.")
    @Test
    void withNotNumberListConvert() {
        for (String input : notCorrectWitNotNumbers) {
            assertThrows(IllegalArgumentException.class, () -> {
                user = new User(new Scanner(input));
                user.userInput();
            });
            userNumbers.clear();
        }
    }
}
