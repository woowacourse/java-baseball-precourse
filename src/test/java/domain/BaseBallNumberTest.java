package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBall 숫자에 대한 테스트")
class BaseBallNumberTest {

	@Test
	@DisplayName("경계값을 넘었을 때의 BaseBallNumber 익셉션 체크")
	void checkThrow() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			BaseBallNumber baseBallNumber = new BaseBallNumber(0);
		});
	}

	@Test
	@DisplayName("경계값을 넘지 않았을 때 BaseBallNumber 객체 생성 체크")
	void name() {
		BaseBallNumber baseBallNumber = new BaseBallNumber(1);
		assertThat(baseBallNumber.getValue()).isEqualTo(1);
	}
}