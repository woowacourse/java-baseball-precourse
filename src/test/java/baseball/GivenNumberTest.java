package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class GivenNumberTest {
    private Set<Integer> generatedNumbers = Stream.of(7, 1, 3).collect(Collectors.toCollection(LinkedHashSet::new));

    @Test
    void 정해진_수와_입력값을_비교해서_결과를_출력_스트라이크_볼_모두_포함() {
        Integer[] inputNumber = {1, 2, 3};

        GivenNumber givenNumber = new GivenNumber(generatedNumbers);
        GameResult gameResult = givenNumber.calculateGameResult(inputNumber);

        assertThat(gameResult.toPrint()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 정해진_수와_입력값을_비교해서_결과를_출력_볼만_포함() {
        Integer[] inputNumber = {6, 7, 1};

        GivenNumber givenNumber = new GivenNumber(generatedNumbers);
        GameResult gameResult = givenNumber.calculateGameResult(inputNumber);

        assertThat(gameResult.toPrint()).isEqualTo("2볼");
    }

    @Test
    void 정해진_수와_입력값을_비교해서_결과를_출력_스트라이크만_포함() {
        Integer[] inputNumber = {2, 1, 6};

        GivenNumber givenNumber = new GivenNumber(generatedNumbers);
        GameResult gameResult = givenNumber.calculateGameResult(inputNumber);

        assertThat(gameResult.toPrint()).isEqualTo("1스트라이크");
    }

    @Test
    void 정해진_수와_입력값을_비교해서_결과를_출력_낫싱() {
        Integer[] inputNumber = {2, 8, 9};

        GivenNumber givenNumber = new GivenNumber(generatedNumbers);
        GameResult gameResult = givenNumber.calculateGameResult(inputNumber);

        assertThat(gameResult.toPrint()).isEqualTo("낫싱");
    }
}
