package players.user;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.checker.NumberChecker;
import baseball.players.numbers.UserNumbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputCheckTest {
    private final UserNumbers userNumbers = new UserNumbers();
    // 올바른 입력
    private final String[] correctUserInputs = {"123", "329", "912", "813"};
    // 세 자리가 아닌 입력, 0이 포함된 숫자, 중복된 수가 있는 입력
    private final String[] notCorrectOnlyNumbers = {"1", "12", "1234", "120", "122"};
    // 세 자리가 아닌 입력, 1~9 이외의 문자 포함
    private final String[] notCorrectWitNotNumbers
        = {"", "\n", " ", "\t", "1 3", "3k5", "1\n", "3\t6", "\n\t\r"};

    @AfterEach
    void clearUserNumbers() {
        userNumbers.clear();
    }

    // 올바른 입력
    @DisplayName("올바른 입력 리스트 변환")
    @Test
    void correctInputListConvert() {
        assertDoesNotThrow(() -> {
            for (String input : correctUserInputs) {
                userNumbers.convertToList(input);
            }
        });
    }

    @DisplayName("올바른 입력 조건 검사 통과")
    @Test
    void correctInputValidation() {
        for (String input : correctUserInputs) {
            userNumbers.convertToList(input);
            assertDoesNotThrow(() -> {
                NumberChecker.checkNumbers(userNumbers.getNumbers());
            });
            userNumbers.clear();
        }
    }

    // 세 자리가 아닌 입력, 0이 포함된 숫자, 중복된 수가 있는 입력
    @DisplayName("조건에 맞지 않아도 숫자로만 이루어져 있으면 에러없이 리스트로 변환된다.")
    @Test
    void onlyNumbersListConvert() {
        assertDoesNotThrow(() -> {
            for (String input : notCorrectOnlyNumbers) {
                userNumbers.convertToList(input);
            }
        });
    }

    @DisplayName("세 자리가 아닌 입력, 0이 포함된 숫자, 중복된 수가 있는 입력 에러")
    @Test
    void notCorrectOnlyNumbersValidation() {
        for (String input : notCorrectOnlyNumbers) {
            userNumbers.convertToList(input);
            assertThrows(IllegalArgumentException.class, () -> {
                NumberChecker.checkNumbers(userNumbers.getNumbers());
            });
            userNumbers.clear();
        }
    }

    // 세 자리가 아닌 입력, 1~9 이외의 문자 포함
    @DisplayName("숫자이외의 문자입력이 있으면 리스트 변환시 IllegalArgumentException이 발생한다.")
    @Test
    void withNotNumberListConvert() {
        assertThrows(IllegalArgumentException.class, () -> {
            for (String input : notCorrectWitNotNumbers) {
                userNumbers.convertToList(input);
            }
        });
    }
}
