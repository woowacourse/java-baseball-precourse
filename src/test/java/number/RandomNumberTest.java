package number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author junyoung.choi
 */
class RandomNumberTest {

    RandomNumber randomNumber = new RandomNumber();
    int[] ranNum = randomNumber.getRandomNumber();

    @Test
    public void create(){
        assertEquals(ranNum.length, 3);
    }

    @Test
    public void isAppropriateNumber(){
        assertTrue((ranNum[0] >= 0) && (ranNum[0] < 10));
        assertTrue((ranNum[1] >= 0) && (ranNum[1] < 10));
        assertTrue((ranNum[2] >= 0) && (ranNum[2] < 10));
    }

    @Test
    public void isAllDifferent(){
        assertNotEquals(ranNum[0], ranNum[1]);
        assertNotEquals(ranNum[0], ranNum[2]);
        assertNotEquals(ranNum[1], ranNum[2]);
    }


}