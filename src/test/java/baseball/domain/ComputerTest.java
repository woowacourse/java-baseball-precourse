package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
	@DisplayName("생성한 3자리 랜덤값을 일급컬렉션으로 유효성체크 테스트")
	@Test
	void checkValidation() {
		for (int i = 0; i < 10000; i++) {
			Computer.getInstance().init();
		}
	}
}
