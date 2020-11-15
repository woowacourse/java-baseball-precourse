package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BaseballGameStatusTest {

	@Test
	void testBaseballGameStatus() {
		assertThatThrownBy(() -> BaseballGameStatus.get("3"))
		.isInstanceOf(IllegalArgumentException.class);
	}

}
