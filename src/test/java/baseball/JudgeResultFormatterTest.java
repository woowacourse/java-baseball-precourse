package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class JudgeResultFormatterTest {
	@Test
	void format_message_only_ball() throws Exception {
		JudgeResultFormatter formatter = new JudgeResultFormatter();
		assertThat(formatter.format(JudgeResult.of(0, 2))).isEqualTo("2볼");
	}
}
