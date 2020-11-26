package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class BallNumberTest {

    @Test
    public void insertNumber() throws Exception {
        //given
        int number = 5;
        BallNumber ballNumber = new BallNumber(5);

        //when
        int findNumber = ballNumber.getNumber();

        //then
        assertEquals(number, findNumber);
    }

    @Test
    public void insertNumberThrowsIllegalArgumentException()  {
        //given
        boolean thrown = false;

        //when
        try{
            BallNumber ballNumber = new BallNumber(10);
        } catch ( IllegalArgumentException e){
            thrown = true;
        }

        //then
        assertEquals(true, thrown);
    }
}