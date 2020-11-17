package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {

	@Test
	void testBaseballNumber() {
		BaseballNumber baseballNumber = new BaseballNumber(1);
		assertThat(baseballNumber.toString()).isEqualTo("1");
	}
	
	@Test
    void testValidate() {
        assertThatThrownBy(() -> new BaseballNumber(10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
