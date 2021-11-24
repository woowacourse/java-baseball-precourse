package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class JudgeResultFormatterTest {
	@Test
	void format_message_only_ball() throws Exception {
		JudgeResultFormatter formatter = new JudgeResultFormatter();
		assertThat(formatter.format(JudgeResult.of(0, 2))).isEqualTo("2볼");
	}

	@Test
	void format_message_only_strike() throws Exception {
		JudgeResultFormatter formatter = new JudgeResultFormatter();
		assertThat(formatter.format(JudgeResult.of(2, 0))).isEqualTo("2스트라이크");
	}

	@Test
	void format_message_both_strike_and_ball() throws Exception {
	 	JudgeResultFormatter formatter = new JudgeResultFormatter();
	 	assertThat(formatter.format(JudgeResult.of(2, 1))).isEqualTo("1볼 2스트라이크");
	}
}
