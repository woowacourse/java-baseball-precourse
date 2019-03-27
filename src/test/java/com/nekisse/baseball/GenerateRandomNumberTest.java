package com.nekisse.baseball;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateRandomNumberTest {

    @Test
    public void 세개의_수가_반환된다() {

        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

        BaseballNumbers baseballGameNumbers = generateRandomNumber.createBaseballGameNumbers();

        assertThat(baseballGameNumbers.getThreeNumber().size()).isEqualTo(GenerateRandomNumber.BASEBALL_GAME_LIMIT_NUM);
    }

    @Test
    public void 생성된_번호는_중복되지않는다() {

        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber() {
            @Override
            protected void shuffleNum(List<Integer> numbers) {
                //섞지 않는다
            }
        };

        BaseballNumbers baseballGameNumbers = generateRandomNumber.createBaseballGameNumbers();

        List<Number> distinctGameNumbers = baseballGameNumbers.getThreeNumber().stream()
            .distinct()
            .collect(Collectors.toList());
        assertThat(distinctGameNumbers.size()).isEqualTo(GenerateRandomNumber.BASEBALL_GAME_LIMIT_NUM);
    }
}
