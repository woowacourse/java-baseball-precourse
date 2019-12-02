
/*
 * NumbersGenerator.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator implements NumbersGenerator{
    /**
     * This method is used to randomly generate three different digits from 1 to 9.
     * @return String joining three digits.
     */
    public String generate() {
        List<Integer> baseNumbers = IntStream.range(Numbers.MIN_NUMBER, Numbers.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(baseNumbers);

        return baseNumbers.stream()
                .limit(Numbers.SIZE)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}