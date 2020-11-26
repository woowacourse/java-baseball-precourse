package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RandomNumberGenerator {
    private static final int MAX_GENERATE_COUNT=3;
    private static Set<Integer> generatedNumber=new LinkedHashSet<>();

    public static String generate(){
        while(generatedNumber.size()!=MAX_GENERATE_COUNT){
            generatedNumber.add(RandomUtils.nextInt(1,9));
        }
        return parseToString();
    }

    private static String parseToString(){
        StringBuilder sb=new StringBuilder();
        generatedNumber.forEach(sb::append);
        return sb.toString();
    }
}
