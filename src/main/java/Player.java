/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Player.java
 *
 * @author      Sorin Jin
 * @version      1.0
 * @date      03 Dec 2019
 *
 */

import java.util.HashSet;
import java.util.Scanner;

public class Player {

    String input;

    private boolean checkInput(){
        // 숫자 판단
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            System.out.println(Message.INPUT_ERROR_NOT_A_NUMBER);
            return false;
        }
        // 자리수 판단
        if(input.length()!=Computer.RANDOM_NUMBER_SIZE){
            System.out.println(Message.INPUT_ERROR_WRONG_DIGIT);
            return false;
        }
        // 범위 판단
        if(input.contains("0")){
            System.out.println(Message.INPUT_ERROR_WRONG_RANGE);
            return false;
        }
        // 중복 값 판단
        HashSet<Integer> answerSet = new HashSet<>();
        for(int i=0; i<input.length(); i++){
            answerSet.add(Character.getNumericValue(input.charAt(i)));
        }
        if(answerSet.size()!=Computer.RANDOM_NUMBER_SIZE){
            System.out.println(Message.INPUT_ERROR_DUPLICATION);
            return false;
        }
        return true;
    }

    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(Message.GET_ANSWER);
        do{
            input = scanner.next();
        }while(!checkInput());
    }
}