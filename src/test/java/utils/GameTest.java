package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    final Scanner scanner = new Scanner(System.in);

    @Test
    @DisplayName("랜덤 숫자 리스트를 생성해야 한다")
    void randomNumberList() {
        //given
        Game game = Game.of(scanner);
        List<Integer> tmpList = new ArrayList<>();

        //when
        List<Integer> randomList = game.createRandomList(3);
        for (Integer integer : randomList) {
            if (!tmpList.contains(integer)) {
                tmpList.add(integer);
            }
        }

        //then
        Assertions.assertThat(randomList.size()).isEqualTo(tmpList.size());
    }
}