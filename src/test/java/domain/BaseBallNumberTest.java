package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBall 숫자에 대한 테스트")
class BaseBallNumberTest {

	@Test
	@DisplayName("경계값을 넘었을 때의 BaseBallNumber 익셉션 체크")
	void checkThrow() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			BaseBallNumber.of(0);
		});
	}

	@Test
	@DisplayName("경계값을 넘지 않았을 때 BaseBallNumber 객체 생성 체크")
	void name() {
		assertThat(BaseBallNumber.of(1).getValue()).isEqualTo(1);
	}

	@Test
	@DisplayName("equal 로직 오버라이딩 테스트")
	void equal() {
		BaseBallNumber one1 = BaseBallNumber.of(1);
		BaseBallNumber one2 = BaseBallNumber.of(1);
		BaseBallNumber two = BaseBallNumber.of(2);
		assertAll(
			() -> assertTrue(one1.equals(one2)),
			() -> assertFalse(one1.equals(two))
		);

	}

}