package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import baseball.domain.GameBoard;

class OutputViewTest {
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();

	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(output));
	}

	@ParameterizedTest
	@CsvSource(value = {"1,0,1스트라이크", "2,0,2스트라이크", "3,0,3스트라이크"})
	public void 스트라이크_출력_테스트(long strike, long ball, String answer) {
		OutputView.showHintMessage(new GameBoard(strike, ball));
		assertEquals(output.toString(), answer + NEW_LINE);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,1,1볼", "0,2,2볼", "0,3,3볼"})
	public void 볼_출력_테스트(long strike, long ball, String answer) {
		OutputView.showHintMessage(new GameBoard(strike, ball));
		assertEquals(output.toString(), answer + SPACE + NEW_LINE);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0,낫싱"})
	public void 낫싱_출력_테스트(long strike, long ball, String answer) {
		OutputView.showHintMessage(new GameBoard(strike, ball));
		assertEquals(output.toString(), answer + NEW_LINE);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1,1볼 1스트라이크", "1,2,2볼 1스트라이크"})
	public void 스트라이크_볼_출력_테스트(long strike, long ball, String answer) {
		OutputView.showHintMessage(new GameBoard(strike, ball));
		assertEquals(output.toString(), answer + NEW_LINE);
	}
}