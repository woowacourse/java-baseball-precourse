import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {
    @Test
    public void create() {
        Play play = new Play();
        assertThat(play).isNotNull();
        System.out.println(play.whatIsAnswer());
    }

    @Test
    public void guess() {
        Play play = new Play();
        int[] numbers1 = new int[]{1, 2, 3, 4};
        int[] numbers2 = new int[]{3, 3, 4};
        int[] numbers3 = new int[]{2, 3, 4};
        assertThat(play.numCheck(1234, numbers1)).isEqualTo(1);
        assertThat(play.numCheck(334, numbers2)).isEqualTo(2);
        assertThat(play.numCheck(234, numbers3)).isEqualTo(0);
    }
}