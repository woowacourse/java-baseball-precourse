package baseball.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    private static final int NUMBERS_LENGTH = 3;

    @Test
    public void outOfLengthExceptionTest(){
        try{
            Numbers.valueOf("1234");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertThatThrownBy(() -> {
            Numbers.valueOf("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void overLappingExceptionTest(){
        try{
            Numbers.valueOf("122");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertThatThrownBy(() -> {
            Numbers.valueOf("122");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void outOfRangeExceptionTest(){
        try{
            Numbers.valueOf("a23");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertThatThrownBy(() -> {
            Numbers.valueOf("a23");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void toStringTest(){
        System.out.println(Numbers.valueOf("123"));
        assertThat(Numbers.valueOf("123").toString()).isEqualTo("123");
    }

    @Test
    public void createRandomNumbersTest(){
        System.out.println(Numbers.createRandomNumbers());
    }
}
