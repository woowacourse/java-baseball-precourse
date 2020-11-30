package baseball;
/*
 * ComparatorTest
 *
 * version 1.0
 *
 * 2020.11.30
 *
 * Copyright (c) by Davinci.J
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparatorTest {

    @Test
    public void testCase1(){
        //GIVEN
        String randomNumbersOfCompetitor = "638";
        String numbersOfGamePlayer = "269";
        String expectedResult = "1볼";

        //WHEN
        String actualResult = Comparator.compareNumbersOfCompetitorAndPlayer(randomNumbersOfCompetitor,
                                                                                numbersOfGamePlayer);
        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase2(){
        //GIVEN
        String randomNumbersOfCompetitor = "638";
        String numbersOfGamePlayer = "149";
        String expectedResult = "낫싱";

        //WHEN
        String actualResult = Comparator.compareNumbersOfCompetitorAndPlayer(randomNumbersOfCompetitor,
                numbersOfGamePlayer);
        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase3(){
        //GIVEN
        String randomNumbersOfCompetitor = "638";
        String numbersOfGamePlayer = "368";
        String expectedResult = "2볼 1스트라이크";

        //WHEN
        String actualResult = Comparator.compareNumbersOfCompetitorAndPlayer(randomNumbersOfCompetitor,
                numbersOfGamePlayer);
        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase4(){
        //GIVEN
        String randomNumbersOfCompetitor = "638";
        String numbersOfGamePlayer = "638";
        String expectedResult = "3스트라이크";

        //WHEN
        String actualResult = Comparator.compareNumbersOfCompetitorAndPlayer(randomNumbersOfCompetitor,
                numbersOfGamePlayer);
        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase5(){
        //GIVEN
        String randomNumbersOfCompetitor = "638";
        String numbersOfGamePlayer = "361";
        String expectedResult = "2볼";

        //WHEN
        String actualResult = Comparator.compareNumbersOfCompetitorAndPlayer(randomNumbersOfCompetitor,
                numbersOfGamePlayer);
        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase6(){
        //GIVEN
        String randomNumbersOfCompetitor = "638";
        String numbersOfGamePlayer = "863";
        String expectedResult = "3볼";

        //WHEN
        String actualResult = Comparator.compareNumbersOfCompetitorAndPlayer(randomNumbersOfCompetitor,
                numbersOfGamePlayer);
        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase7(){
        //GIVEN
        String randomNumbersOfCompetitor = "638";
        String numbersOfGamePlayer = "236";
        String expectedResult = "1볼 1스트라이크";

        //WHEN
        String actualResult = Comparator.compareNumbersOfCompetitorAndPlayer(randomNumbersOfCompetitor,
                numbersOfGamePlayer);
        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
