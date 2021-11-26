package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputManagerTest {
	private InputManager inputManager;

	@BeforeEach
	void setup() {
		inputManager = new InputManager();
	}

	@Test
	void 플레이어_정상정답() {
		String input = "123";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		int[] guessArray = inputManager.inputGuess();
		int[] intArray = {1, 2, 3};
		Assertions.assertArrayEquals(guessArray, intArray);
	}

	@Test
	void 플레이어_숫자아닌정답() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String input = "1A3";
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			int[] guessArray = inputManager.inputGuess();
		});
	}

	@Test
	void 플레이어_3보다긴정답() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String input = "1234";
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			int[] guessArray = inputManager.inputGuess();
		});
	}

	@Test
	void 플레이어_3보다짧은정답() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String input = "1";
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			int[] guessArray = inputManager.inputGuess();
		});
	}

	@Test
	void 재시작의사() {
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		int restartNum = inputManager.inputRestartNum();
		Assertions.assertEquals(restartNum, 1);
	}

	@Test
	void 재시작의사_1혹은2아님() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String input = "c";
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			int restartNum = inputManager.inputRestartNum();
		});
	}
}