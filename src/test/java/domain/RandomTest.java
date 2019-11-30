package domain;

import annotation.TestDescription;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RandomTest {
    private static final int MILLION = 1000000;
    private static final RandomNumber random = new RandomNumber();

    @Test
    @TestDescription("서로 다른 세 자리수임을 확인하는 테스트입니다.")
    public void testRandomNumberRange(){
        RandomNumber random = new RandomNumber();

        for(int i=0; i<MILLION; i++){
            int randomNumber = random.makeNumber();
            assertTrue(randomNumber >=100);
            assertTrue(randomNumber<1000);
        }
    }
    @Test
    @TestDescription("생성된 세자리 수가 서로 다른 수 인지를 테스트합니다.")
    public void testEachDigitNumber(){
        Set<String> setForDigitNumber = new HashSet<>();

        for(int i=0; i<MILLION; i++){
            setForDigitNumber.clear();
            int randomNumber = random.makeNumber();
            String[] randomArray = String.valueOf(randomNumber).split("");
            for(int j=0; j<randomArray.length; j++){
                setForDigitNumber.add(randomArray[j]);
            }
            assertEquals(setForDigitNumber.size(), 3);
        }

    }


}
