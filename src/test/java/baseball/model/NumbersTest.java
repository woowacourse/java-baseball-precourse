package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    private static final int NUMBERS_LENGTH = 3;

    @Test
    public void outOfLengthExceptionTest(){
        try{
            Numbers.from("1234");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertThatThrownBy(() -> {
            Numbers.from("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void overLappingExceptionTest(){
        try{
            Numbers.from("122");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertThatThrownBy(() -> {
            Numbers.from("122");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void outOfRangeExceptionTest(){
        try{
            Numbers.from("a23");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertThatThrownBy(() -> {
            Numbers.from("a23");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void toStringTest(){
        System.out.println(Numbers.from("123"));
        assertThat(Numbers.from("123").toString()).isEqualTo("123");
    }

    @Test
    public void createRandomNumbersTest(){
        System.out.println(Numbers.createRandomNumbers());
    }
}
