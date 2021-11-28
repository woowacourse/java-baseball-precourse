package baseball.model;

import baseball.model.Computer.Computer;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

}