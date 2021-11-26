package input;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

//TDD
class ComputerTest {

    @Test
    void 테스트를_테스트(){

    }

    @Test
    void 출력_테스트() {
        //given
        Computer computer = new Computer();
        Set<Integer> randomNumbers;

        //when
        randomNumbers = computer.extractRandomNumbers();

        //then
        //서로 다른 수로 이루어져야 하므로 집합의 크기가 3이여야 한다.
        assertEquals(randomNumbers.size(), 3);

        //랜덤으로 추출된 값이 숫자여야한다.
        randomNumbers.stream().forEach(
                n -> assertTrue(n >= 1 && n <= 9)
        );


    }

}