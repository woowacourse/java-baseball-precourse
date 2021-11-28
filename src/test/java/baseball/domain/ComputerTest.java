package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    //3자리의 수가 맞는지 확인 및 중복된 숫자가 없는지 확인
    @Test
    public void 랜덤_수_생성(){
        Computer computer = new Computer();
        ArrayList<String> strings = computer.makeRandom();

        assertEquals(strings.size(), 3);

        HashSet<String> numSet = new HashSet<>(strings);
        assertEquals(strings.size(), numSet.size());
    }
}