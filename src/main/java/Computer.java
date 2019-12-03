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

import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Random;

@Getter
public class Computer{
    static final int RANDOM_NUMBER_SIZE = 3;
    static final int MIN_RANGE = 1;
    static final int MAX_RANGE = 9;

    String randomNumber;
    Result result;

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

    public Result checkAnswer(String playerNumber){
        result = new Result();
        for(int i=0; i<RANDOM_NUMBER_SIZE; i++){
            if(randomNumber.charAt(i) == playerNumber.charAt(i)){
                result.setNumberOfStrike(result.getNumberOfStrike()+1);
            }else if(randomNumber.contains(Character.toString(playerNumber.charAt(i)))){
                result.setNumberOfBall(result.getNumberOfBall()+1);
            }
        }
        return result;
    }

    public void printScore(){
        if(result.getNumberOfBall() == 0 && result.getNumberOfStrike() == 0){
            System.out.println(Message.NOTHING);
        }else {
            if(result.getNumberOfBall() != 0){
                System.out.print(result.getNumberOfBall()+Message.BALL);
            }
            if(result.getNumberOfStrike() != 0){
                System.out.print(result.getNumberOfStrike()+Message.STRIKE);
            }
            System.out.println();
        }
    }
}
