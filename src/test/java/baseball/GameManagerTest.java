package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class GameManagerTest {
	BaseballNumberReferee referee;
	BaseballNumberGenerator generator;
	JudgeResultFormatter formatter;

	@BeforeEach
	void setUp() throws Exception {
		referee = new BaseballNumberReferee(new BaseballNumberValidator());
		generator = new BaseballNumberGenerator(new BaseballNumberValidator());
		formatter = new JudgeResultFormatter();
	}

	@Test
	@DisplayName("게임을 시작하면 \"숫자를 입력하세요 : \" 메시지 출력")
	void display_input_number_message_when_start_game() throws Exception {
		Display display = mock(Display.class);
		GameManager gameManager = new GameManager(display, generator, referee, formatter);

		gameManager.startGame();

		then(display).should().print("숫자를 입력하세요 : ");
	}

	@Test
	@DisplayName("입력한 숫자의 결과를 출력")
	void display_judge_result_message_when_input_number() throws Exception {
		Display display = mock(Display.class);
		generator = mock(BaseballNumberGenerator.class);
		when(generator.generate()).thenReturn("123");
		GameManager gameManager = new GameManager(display, generator, referee, formatter);

		gameManager.startGame();
		gameManager.handleGuessNumber("132");
		gameManager.handleGuessNumber("461");
		gameManager.handleGuessNumber("156");
		gameManager.handleGuessNumber("569");

		InOrder inOrder = inOrder(display);
		inOrder.verify(display).print("숫자를 입력하세요 : ");
		inOrder.verify(display).println("2볼 1스트라이크");
		inOrder.verify(display).print("숫자를 입력하세요 : ");
		inOrder.verify(display).println("1볼");
		inOrder.verify(display).print("숫자를 입력하세요 : ");
		inOrder.verify(display).println("1스트라이크");
		inOrder.verify(display).print("숫자를 입력하세요 : ");
		inOrder.verify(display).println("낫싱");
		inOrder.verify(display).print("숫자를 입력하세요 : ");

		assertThat(gameManager.isGameFinished()).isFalse();
	}

	@Test
	@DisplayName("삼진아웃일 경우 게임 종료 메시지 출력")
	void display_end_message_when_strikeout() throws Exception {
		Display display = mock(Display.class);
		generator = mock(BaseballNumberGenerator.class);
		when(generator.generate()).thenReturn("123");
		GameManager gameManager = new GameManager(display, generator, referee, formatter);

		gameManager.startGame();
		gameManager.handleGuessNumber("123");

		InOrder inOrder = inOrder(display);
		inOrder.verify(display).print("숫자를 입력하세요 : ");
		inOrder.verify(display).println("3스트라이크");
		inOrder.verify(display).println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		inOrder.verify(display).println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		assertThat(gameManager.isGameFinished()).isTrue();
	}

	@Test
	@DisplayName("게임 재시작")
	void restart_game() throws Exception {
		Display display = mock(Display.class);
		generator = mock(BaseballNumberGenerator.class);
		when(generator.generate())
			.thenReturn("123")
			.thenReturn("456");
		GameManager gameManager = new GameManager(display, generator, referee, formatter);

		gameManager.startGame();
		gameManager.handleGuessNumber("123");
		assertThat(gameManager.isGameFinished()).isTrue();

		gameManager.handleOptionNumber("1");
		assertThat(gameManager.isGameFinished()).isFalse();
		gameManager.handleGuessNumber("456");
		gameManager.handleOptionNumber("2");
		assertThat(gameManager.isGameFinished()).isTrue();

		InOrder inOrder = inOrder(display, generator);
		inOrder.verify(display).print("숫자를 입력하세요 : ");
		inOrder.verify(display).println("3스트라이크");
		inOrder.verify(display).println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		inOrder.verify(display).println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		inOrder.verify(generator).generate();
		inOrder.verify(display).print("숫자를 입력하세요 : ");
		inOrder.verify(display).println("3스트라이크");
		inOrder.verify(display).println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		inOrder.verify(display).println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
