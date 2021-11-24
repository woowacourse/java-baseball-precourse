package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

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
		Console console = mock(Console.class);
		GameManager gameManager = new GameManager(console, generator, referee, formatter);

		gameManager.startGame();

		then(console).should().print("숫자를 입력하세요 : ");
	}

	@Test
	@DisplayName("입력한 숫자의 결과를 출력")
	void display_judge_result_message_when_input_number() throws Exception {
		Console console = mock(Console.class);
		generator = mock(BaseballNumberGenerator.class);
		when(generator.generate()).thenReturn("123");
		GameManager gameManager = new GameManager(console, generator, referee, formatter);

		gameManager.startGame();
		gameManager.handleGuessNumber("132");
		gameManager.handleGuessNumber("461");
		gameManager.handleGuessNumber("156");
		gameManager.handleGuessNumber("569");

		InOrder inOrder = inOrder(console);
		inOrder.verify(console).print("숫자를 입력하세요 : ");
		inOrder.verify(console).println("2볼 1스트라이크");
		inOrder.verify(console).print("숫자를 입력하세요 : ");
		inOrder.verify(console).println("1볼");
		inOrder.verify(console).print("숫자를 입력하세요 : ");
		inOrder.verify(console).println("1스트라이크");
		inOrder.verify(console).print("숫자를 입력하세요 : ");
		inOrder.verify(console).println("낫싱");
		inOrder.verify(console).print("숫자를 입력하세요 : ");

		assertThat(gameManager.isGameFinished()).isFalse();
	}
}
