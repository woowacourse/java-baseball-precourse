package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("ComputerPlayer 클래스")
class ComputerPlayerTest {
	@Nested
	@DisplayName("생성자에 RandomNumber인스턴스를 인자로 넘기지 않은 ComputerPlayer의 인스턴스는")
	class ComputerPlayerConstructorWithoutParameter {
		@Test
		@DisplayName("3자리의 난수를 스트링으로 생성한다")
		void getThreeDigitsNumberAsString() {
			final Player computerPlayer = new ComputerPlayer();

			Assertions.assertFalse(computerPlayer.getSelectedNumber().isEmpty());
			Assertions.assertEquals(computerPlayer.getSelectedNumber().length(), 3);
		}
	}

	@Nested
	@DisplayName("생성자에 RandomNumber 인스턴스를 인자로 넘긴 ComputerPlayer의 인스턴스는")
	class ComputerPlayerConstructorWithParameter {
		@Test
		@DisplayName("3자리 난수를 스트링으로 생성한다")
		void getThreeDigitsNumberAsString() {
			final Player computerPlayer = new ComputerPlayer(new RandomNumber());

			Assertions.assertFalse(computerPlayer.getSelectedNumber().isEmpty());
			Assertions.assertEquals(computerPlayer.getSelectedNumber().length(), 3);
		}
	}


}
