package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.domain.vo.BallStrikeCount;
import baseball.domain.vo.number.Number;

class NumberTest {

    // 이건 Number 테스트?
    // BallStrikeCount 테스트??
    // 하드 코딩을 해야 할까?

    @Test
    public void 공격숫자와_컴퓨터숫자가_일치하지않으면_낫싱_인스턴스를_리턴한다() {
        // given
        Number givenNumber1 = new Number("123");
        Number givenNumber2 = new Number("456");

        // when
        BallStrikeCount actual = givenNumber1.compare(givenNumber2);

        // then
        assertTrue(actual.isNothing());
    }

    @Test
    public void 공격숫자와_컴퓨터숫자가_자릿_수_까지_일치하면_3Strike_인스턴스를_리턴한다() {
        // given
        Number givenNumber1 = new Number("123");
        Number givenNumber2 = new Number("123");

        // when
        BallStrikeCount actual = givenNumber1.compare(givenNumber2);

        // then
        assertTrue(actual.isThreeStrike());
    }

}