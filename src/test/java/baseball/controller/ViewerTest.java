package baseball.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ViewerTest {
    private Viewer viewer;
    private static final int END_NUMBER = 9;
    private static final int START_NUMBER = 1;

    @BeforeEach
    void beforeEachViewerTest() {
        this.viewer = new Viewer(new Scanner(System.in));
    }

    @Test
    void createRandomBallNumberList() {
        // given
        List<Integer> randomBaseballList = this.viewer.createRandomBallNumberList();

        // when
        Set<Integer> randomBaseballset = new HashSet<>(randomBaseballList);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int baseballElement : randomBaseballList) {
            min = Math.min(min, baseballElement);
            max = Math.max(max, baseballElement);
        }

        // then
        assertThat(randomBaseballList.size() > 0).isTrue();
        assertThat(randomBaseballList.size() == randomBaseballset.size()).isTrue();
        assertThat(START_NUMBER <= min && max <= END_NUMBER).isTrue();
    }
}