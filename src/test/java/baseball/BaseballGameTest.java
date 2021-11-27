package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("BaseballGame 클래스")
class BaseballGameTest {
	@Nested
	@DisplayName("컴퓨터 플레이어와 사람 플레이어가 값을 고른다. 사람 플레이어의 값이")
	class HumanPlayerSelectedNumber {
		@DisplayName("3자리 자연수 형태의 스트링이면 값을 할당한다")
		@ParameterizedTest
		@CsvSource(value = {"100", "999", "500"})
		void playerSelectedRightNumber(final String humanSelectedNumber) {
			final Player humanPlayer = new HumanPlayer();
			final Player computerPlayer = new ComputerPlayer();

			humanPlayer.setSelectedNumber(humanSelectedNumber);

			Assertions.assertAll(
				() -> assertFalse(humanPlayer.getSelectedNumber().isEmpty()),
				() -> assertEquals(humanPlayer.getSelectedNumber().length(), 3)
			);
			Assertions.assertAll(
				() -> assertFalse(computerPlayer.getSelectedNumber().isEmpty()),
				() -> assertEquals(computerPlayer.getSelectedNumber().length(), 3)
			);
		}

		@DisplayName("3자리 자연수 형태의 스트링이 아니면 IllegalArgumentException을 발생시키고 애플리케이션을 종료한다")
		@ParameterizedTest
		@CsvSource(value = {"-100", "99 9 ", "1000", "12.3", "a.8"})
		void playerSelectedWrongNumber(final String humanSelectedNumber) {
			final Player humanPlayer = new HumanPlayer();
			final Player computerPlayer = new ComputerPlayer();

			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> humanPlayer.setSelectedNumber(humanSelectedNumber));
			assertEquals("유효하지 않은 숫자형식입니다.", invalidInput.getMessage());
			Assertions.assertAll(
				() -> assertFalse(computerPlayer.getSelectedNumber().isEmpty()),
				() -> assertEquals(computerPlayer.getSelectedNumber().length(), 3)
			);
		}
	}

}
