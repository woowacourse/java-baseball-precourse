package com.nekisse.baseball;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    public void 세개의_수가_반환된다() {

        Computer computer = new Computer();

        List<Integer> baseballGameNumbers = computer.createBaseballGameNumbers();

        assertThat(baseballGameNumbers.size()).isEqualTo(Computer.BASEBALL_GAME_LIMIT_NUM);
    }

    @Test
    public void 생성된_번호는_중복되지않는다() {

        Computer computer = new Computer() {
            @Override
            protected void shuffleNum(List<Integer> numbers) {
                //섞지 않는다.
            }
        };

        List<Integer> gameNumbers = computer.createBaseballGameNumbers();

        List<Integer> distinctGameNumbers = gameNumbers.stream()
            .distinct()
            .collect(Collectors.toList());
        assertThat(distinctGameNumbers.size()).isEqualTo(Computer.BASEBALL_GAME_LIMIT_NUM);
    }
}
