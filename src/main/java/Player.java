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

import lombok.Getter;

import java.util.HashSet;
import java.util.Scanner;

@Getter
public class Player {

    String inputNumber;
    Scanner scanner = new Scanner(System.in);

    private boolean checkInputValidation(){
        // 숫자 판단
        try{
            Integer.parseInt(inputNumber);
        }catch(NumberFormatException e){
            System.out.println(Message.INPUT_ERROR_NOT_A_NUMBER);
            return false;
        }
        // 자리수 판단
        if(inputNumber.length()!=Computer.RANDOM_NUMBER_SIZE){
            System.out.println(Message.INPUT_ERROR_WRONG_DIGIT);
            return false;
        }
        // 범위 판단
        if(inputNumber.contains("0")){
            System.out.println(Message.INPUT_ERROR_WRONG_RANGE);
            return false;
        }
        // 중복 값 판단
        HashSet<Integer> answerSet = new HashSet<>();
        for(int i=0; i<inputNumber.length(); i++){
            answerSet.add(Character.getNumericValue(inputNumber.charAt(i)));
        }
        if(answerSet.size()!=Computer.RANDOM_NUMBER_SIZE){
            System.out.println(Message.INPUT_ERROR_DUPLICATION);
            return false;
        }
        return true;
    }

    public String getInput(){
        System.out.print(Message.GET_ANSWER);
        do{
            inputNumber = scanner.next();
        }while(!checkInputValidation());
        return inputNumber;
    }

    public int wantReplay(){
        int answer;
        do{
            System.out.println(Message.GET_ANSWER_RESTART_OR_EXIT);
            answer = scanner.nextInt();
        }while((answer != Game.REPLAY) && (answer != Game.EXIT_GAME));
        return answer;
    }
}