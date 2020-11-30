package baseball;
/*
 * CompetitorTest
 *
 * version 1.0
 *
 * 2020.11.30
 *
 * Copyright (c) by Davinci.J
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class CompetitorTest {
    private Competitor competitor;

    @BeforeEach
    public void prepareTest(){ this.competitor = new Competitor(); }

    @Test
    public void testCase1() {
        //GIVEN
        Set<Character> numbers = new HashSet<>();
        boolean isRightNumbers = true;

        //WHEN
        String generatedRandomNumbers = competitor.getGeneratedRandomNumbers();

        for (int i=0; i<generatedRandomNumbers.length(); i++) {
            char generatedRandomNumber = generatedRandomNumbers.charAt(i);
            numbers.add(generatedRandomNumber);
            if(generatedRandomNumber < '1' || generatedRandomNumber > '9') {
                isRightNumbers = false;
                break;
            }
        }

        if(numbers.size() != 3){
            isRightNumbers = false;
        }

        //THEN
        Assertions.assertTrue(isRightNumbers);
    }

    @Test
    public void testCase2() {
        //GIVEN
        Set<Character> numbers = new HashSet<>();
        boolean isRightNumbers = true;

        //WHEN
        String generatedRandomNumbers = competitor.getGeneratedRandomNumbers();

        for (int i=0; i<generatedRandomNumbers.length(); i++) {
            char generatedRandomNumber = generatedRandomNumbers.charAt(i);
            numbers.add(generatedRandomNumber);
            if(generatedRandomNumber < '1' || generatedRandomNumber > '9') {
                isRightNumbers = false;
                break;
            }
        }

        if(numbers.size() != 3){
            isRightNumbers = false;
        }

        //THEN
        Assertions.assertTrue(isRightNumbers);
    }

    @Test
    public void testCase3() {
        //GIVEN
        Set<Character> numbers = new HashSet<>();
        boolean isRightNumbers = true;

        //WHEN
        String generatedRandomNumbers = competitor.getGeneratedRandomNumbers();

        for (int i=0; i<generatedRandomNumbers.length(); i++) {
            char generatedRandomNumber = generatedRandomNumbers.charAt(i);
            numbers.add(generatedRandomNumber);
            if(generatedRandomNumber < '1' || generatedRandomNumber > '9') {
                isRightNumbers = false;
                break;
            }
        }

        if(numbers.size() != 3){
            isRightNumbers = false;
        }

        //THEN
        Assertions.assertTrue(isRightNumbers);
    }

    @Test
    public void testCase4() {
        //GIVEN
        Set<Character> numbers = new HashSet<>();
        boolean isRightNumbers = true;

        //WHEN
        String generatedRandomNumbers = competitor.getGeneratedRandomNumbers();

        for (int i=0; i<generatedRandomNumbers.length(); i++) {
            char generatedRandomNumber = generatedRandomNumbers.charAt(i);
            numbers.add(generatedRandomNumber);
            if(generatedRandomNumber < '1' || generatedRandomNumber > '9') {
                isRightNumbers = false;
                break;
            }
        }

        if(numbers.size() != 3){
            isRightNumbers = false;
        }

        //THEN
        Assertions.assertTrue(isRightNumbers);
    }

    @Test
    public void testCase5() {
        //GIVEN
        Set<Character> numbers = new HashSet<>();
        boolean isRightNumbers = true;

        //WHEN
        String generatedRandomNumbers = competitor.getGeneratedRandomNumbers();

        for (int i=0; i<generatedRandomNumbers.length(); i++) {
            char generatedRandomNumber = generatedRandomNumbers.charAt(i);
            numbers.add(generatedRandomNumber);
            if(generatedRandomNumber < '1' || generatedRandomNumber > '9') {
                isRightNumbers = false;
                break;
            }
        }

        if(numbers.size() != 3){
            isRightNumbers = false;
        }

        //THEN
        Assertions.assertTrue(isRightNumbers);
    }

}
