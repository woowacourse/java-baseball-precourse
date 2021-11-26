package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setUp(){
        computer = new Computer();
    }

//    @ParameterizedTest
//    @CsvSource(value = {"123: 3스트라이크", "132:1볼 2스트라이크","456 : 낫싱"},delimiter = ':')
//    public void getHintTest(String input, String output){
//        assertThat(computer.getHint(input).isEqualTo(output));
//    }

    @Test
    public void isBallTest(){
        assertThat(computer.CountingBall("123","341")).isEqualTo(2);
    }

    @Test
    public void isStrikeTest(){
        assertThat(computer.CountingStrike("123","123")).isEqualTo(3);
    }
}