package baseball;

import utils.RandomUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class Competitor {
    private static final int FIRST_BOUNDARY_VALUE = 1;
    private static final int LAST_BOUNDARY_VALUE = 9;
    private static final int RANDOM_NUMBER_COUNT = 3;

    public static String getRandomNumbers(){
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while(randomNumbers.size() != RANDOM_NUMBER_COUNT){
            randomNumbers.add(RandomUtils.nextInt(FIRST_BOUNDARY_VALUE, LAST_BOUNDARY_VALUE));
        }
        return getRandomNumbersConvertedToString(randomNumbers);
    }

    private static String getRandomNumbersConvertedToString(Set<Integer> randomNumbers){
        StringBuilder sb = new StringBuilder();
        for(Integer randomNumber : randomNumbers){
            sb.append(randomNumber);
        }
        return sb.toString();
    }
}
