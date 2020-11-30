package baseball;
/*
 * Competitor
 *
 * version 1.0
 *
 * 2020.11.30
 *
 * Copyright (c) by Davinci.J
 */
import utils.RandomUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class Competitor {
    private static final int FIRST_BOUNDARY_VALUE = 1;
    private static final int LAST_BOUNDARY_VALUE = 9;
    private static final int COUNT_LIMIT = 3;

    private final String generatedRandomNumbers;

    public Competitor(){
        this.generatedRandomNumbers = generateRandomNumbers();
    }

    public String getGeneratedRandomNumbers(){
        return this.generatedRandomNumbers;
    }

    private String generateRandomNumbers(){
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while(randomNumbers.size() < COUNT_LIMIT){
            randomNumbers.add(RandomUtils.nextInt(FIRST_BOUNDARY_VALUE, LAST_BOUNDARY_VALUE));
        }
        return convertRandomNumbersIntoString(randomNumbers);
    }

    private static String convertRandomNumbersIntoString(Set<Integer> randomNumbers){
        StringBuilder sb = new StringBuilder();
        for(Integer randomNumber : randomNumbers){
            sb.append(randomNumber);
        }
        return sb.toString();
    }
}
