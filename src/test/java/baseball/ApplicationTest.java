package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import dto.CompareResult;
import service.Computer;
import service.Converter;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // @Test
    void 랜덤_난수생성_비교_테스트() {
        Computer computer = new Computer();
        ArrayList<Integer> givenNumbers = getGivenNumber();
        CompareResult result = computer.compareNumbers(givenNumbers);

        computer.printRandomNumberList_test();
        System.out.println("strike : " + result.getStrike());
        System.out.println("ball : " + result.getBall());
    }

    // @Test
    void 컨버터_입력값_테스트() {
        Converter converter = new Converter();
        converter.convertStringToIntegerList("132");
    }

    private ArrayList<Integer> getGivenNumber() {
        ArrayList<Integer> givenNumbers = new ArrayList<>();
        givenNumbers.add(7);
        givenNumbers.add(8);
        givenNumbers.add(9);

        return givenNumbers;
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
