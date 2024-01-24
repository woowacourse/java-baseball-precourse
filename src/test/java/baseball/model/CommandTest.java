package baseball.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CommandTest {

    @Test
    void 명령이_재시작인지_확인한다() {
        // given
        Command replay = new Command(1);
        Command stop = new Command(2);

        assertSoftly(softly -> {
            assertTrue(replay.isReplay());
            assertFalse(stop.isReplay());
        });
    }
}