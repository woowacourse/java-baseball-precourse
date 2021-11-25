package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("HumanPlayer 클래스")
class HumanPlayerTest {
	@Nested
	@DisplayName("사람플레이어가 입력한 값이")
	class HumanPlayerSelectedNumber {
		@DisplayName("3자리 자연수 형태의 스트링이면 정상적으로 HumanPlayer 인스턴스에 값을 할당한다")
		@ParameterizedTest
		@CsvSource(value = {"100", "999", "400", "500"})
		void humanPlayerSelectedRightNumber(String selectedNumber) {
			final Player humanPlayer = new HumanPlayer();

			humanPlayer.setSelectedNumber(selectedNumber);

			Assertions.assertAll(
				() -> assertFalse(humanPlayer.getSelectedNumber().isEmpty()),
				() -> assertEquals(humanPlayer.getSelectedNumber().length(), 3)
			);
		}

		@DisplayName("3자리 자연수 형태의 스트링이 아니라면 IllegalArgumentException이 발생하고 애플리케이션이 종료된다")
		@ParameterizedTest
		@CsvSource(value = {"-100", "99 9", "1000", "12.3"})
		void humanPlayerSelectedWrongNumber(String selectedNumber) {
			final Player humanPlayer = new HumanPlayer();

			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> humanPlayer.setSelectedNumber(selectedNumber));
			assertEquals("유효하지 않은 숫자형식입니다.", invalidInput.getMessage());
		}
	}

}
