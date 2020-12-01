package baseball.controller;

import baseball.domain.Computer;
import jdk.jfr.Description;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;
import baseball.util.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static baseball.util.Validator.INPUT_MAX_NUMBER;
import static baseball.util.Validator.INPUT_MIN_NUMBER;

class ComputerTest {


    @Test
    @Description("RandomUtils를 이용한 난수 생성")
    public void createRandomTest(){

        //given
        Set<Integer> set = new HashSet<>();
        //when
        while(set.size() < Validator.REQUIRE_NUMBER_COUNT){
            int random = RandomUtils.nextInt(INPUT_MIN_NUMBER, INPUT_MAX_NUMBER);
            set.add(random);
        }
        //then
        assertEquals(set.size(),Validator.REQUIRE_NUMBER_COUNT);
        System.out.println(set.toString());
    }


    @Test
    @Description("Computer 정적메서드 생성 테스트")
    public void computerMethodTest() {

        //given
        Computer computer = Computer.create();

        //when
        List<Integer> numbers = computer.cloneNumbers();

        //then
        assertNotNull(numbers);

    }

    @Description("RandomUtils.nextInt를 이용한 난수 생성")
    @RepeatedTest(100)
    public void randomUtilsTest(){

        assertTrue(randomRange());

    }

    @Test
    @Description("복사해서 반환한 리스트 불변성 테스트")
    public void cloneListImutableTest(){

        //given
        Computer computer = Computer.create();

        //when
        List<Integer> cloneNumbers = computer.cloneNumbers();

        //then
        assertThrows(Exception.class, ()->{
            cloneNumbers.add(1);
        });

    }

    @Description("해당 숫자를 Computer가 가지고 있다면 true 반환 아닐시 false")
    @RepeatedTest(10)
    public void hasNumberTest() {

        //given
        Computer computer = Computer.create();
        List<Integer> numbers = computer.cloneNumbers();

        //
        for(Integer number : numbers){
            assertTrue(computer.hasNumber(number));
        }
    }

    @Test
    @Description("해당 인덱스에 숫자가 있다면 true 없다면 false반환")
    public void hasNumberOfIndexTest(){

        //given
        Computer computer = Computer.create();
        List<Integer> numbers = computer.cloneNumbers();

        //when

        for (int index = 0; index < numbers.size(); index++) {

            int number = numbers.get(index);

            //then
            assertTrue(computer.hasNumberOfIndex(number,index));

        }

    }

    @Test
    @Description("해당 인덱스에 숫자가 있다면 true 없다면 false반환")
    public void hasNumberOfIndexTest_fail(){

        //given
        Computer computer = Computer.create();
        List<Integer> numbers = computer.cloneNumbers();

        //when
        int indexZeroNum = numbers.get(0);
        int indexOneNum = numbers.get(1);
        int indexTwoNum = numbers.get(2);

        //then
        computer.hasNumberOfIndex(indexOneNum,2);
        computer.hasNumberOfIndex(indexZeroNum,1);
        computer.hasNumberOfIndex(indexTwoNum,0);


    }

    //

    private static boolean randomRange() {
        int number = RandomUtils.nextInt(INPUT_MIN_NUMBER, INPUT_MAX_NUMBER);

        if(number < INPUT_MIN_NUMBER || number > INPUT_MAX_NUMBER ){
            return false;
        }
        return true;

    }

}