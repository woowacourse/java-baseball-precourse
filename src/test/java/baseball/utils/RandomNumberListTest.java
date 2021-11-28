package baseball.utils;

import static baseball.utils.Validator.validateAnswerLength;
import static baseball.utils.Validator.validateUniqueNumber;

import java.util.List;

import org.junit.jupiter.api.Test;

class RandomNumberListTest {
    @Test
    void 정답_숫자_배열_유효성_검증() {
        List<Integer> newRandomNumList;

        for (int i = 0; i < 10; i++) {
            newRandomNumList = RandomNumberList.generate();
            validateUniqueNumber(newRandomNumList);
            validateAnswerLength(newRandomNumList);
        }
    }
}