package stringStudy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 스플릿테스트() {
        //given
        String string = "1,2";

        //when
        String[] splitString = string.split(",");

        //then
        assertThat(splitString).contains("1","2");
    }

    @Test
    void 한자리_숫자_스플릿테스트() {
        //given
        String string = "1";

        //when
        String[] splitString = string.split(",");

        //then
        assertThat(splitString).containsExactly("1");
    }
}
