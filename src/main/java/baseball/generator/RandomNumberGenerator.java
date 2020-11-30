package baseball.generator;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {
    private static final int MIN_START_VALUE = 1;
    private static final int MAX_END_VALUE = 9;

    public static String getRandomNumber(){
        String randomNumber = "";
        Set<Integer> duplicatedNumberChecker = new HashSet<>();
        while(randomNumber.length() < 3) {
            int currentInt = RandomUtils.nextInt(MIN_START_VALUE, MAX_END_VALUE);
            if(!duplicatedNumberChecker.contains(currentInt)){
                randomNumber += Integer.toString(currentInt);
            }
            duplicatedNumberChecker.add(currentInt);
        }
        return randomNumber;
    }
}
