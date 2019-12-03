/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Computer.java
 *
 * @author		Sorin Jin
 * @version		1.0
 * @date		03 Dec 2019
 *
 */

import java.util.LinkedHashSet;
import java.util.Random;

public class Computer{

    static final int RANDOM_NUMBER_SIZE = 3;
    static final int MIN_RANGE = 1;
    static final int MAX_RANGE = 9;

    String randomNumber;

    public void generateRandomNumber(){
        StringBuilder number = new StringBuilder();
        Random random = new Random();
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();
        while(randomNumberSet.size()<RANDOM_NUMBER_SIZE){
            randomNumberSet.add(random.nextInt(MAX_RANGE) + MIN_RANGE);
        }
        for(Integer num : randomNumberSet){
            number.append(num);
        }
        randomNumber = number.toString();
    }
}
