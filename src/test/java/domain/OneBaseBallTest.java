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
}