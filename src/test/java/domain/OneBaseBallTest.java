package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("position과 number를 가진 하나의 BaseBall 생성")
class OneBaseBallTest {

	@Test
	@DisplayName("postion과 number에 따른 baseball 생성")
	void ofInteger() {
		OneBaseBall oneBaseBall = OneBaseBall.ofInteger(1, 2);

		assertAll(
			() -> assertThat(oneBaseBall.getBaseBallNumber().getValue()).isEqualTo(1),
			() -> assertThat(oneBaseBall.getBaseBallPosition()).isEqualTo(2)
		);
	}

	@Test
	@DisplayName("두 oneBaseBall의 position과 number를 비교하여 strike 판단")
	void equalStrike() {

		OneBaseBall answer = OneBaseBall.ofInteger(1, 2);
		OneBaseBall collectQuestion = OneBaseBall.ofInteger(1, 2);
		OneBaseBall wrongQuestion = OneBaseBall.ofInteger(1, 3);

		assertAll(
			() -> assertTrue(collectQuestion.equalStrike(answer)),
			() -> assertTrue(!wrongQuestion.equalStrike(answer))
		);
	}

	@Test
	@DisplayName("두 oneBaseBall의 position과 number를 비교하여 ball 판단")
	void equalBall() {

		OneBaseBall answer = OneBaseBall.ofInteger(1, 2);
		OneBaseBall collectQuestion = OneBaseBall.ofInteger(1, 3);
		OneBaseBall wrongQuestion = OneBaseBall.ofInteger(1, 2);

		assertAll(
			() -> assertTrue(collectQuestion.equalBall(answer)),
			() -> assertTrue(!wrongQuestion.equalBall(answer))
		);
	}

}