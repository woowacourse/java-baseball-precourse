package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BaseballGameStatusTest {

	@Test
	void testInvalidBaseballGameStatus() {
		assertThatThrownBy(() -> BaseballGameStatus.get("3"))
		.isInstanceOf(NullPointerException.class);
	}
	
	@Test
	void testgetBaseballGameStatus() {
		System.out.println(BaseballGameStatus.get("1"));
	}
}
