/*
 * @BaseballGame.java        1.00 2019/03/26
 * 
 * Copyright(c) 2019         Soojin Roh
 * All rights reserved.
 * 
 * 야구 게임을 구현한 프로그램.
 * 2명의 플레이어가 1~9까지의 서로 다른 정수 세 개를 선택해서 상대방의 숫자를 맞추는 게임입니다.
 * 컴퓨터의 숫자는 Random클래스를 사용해 임의로 생성하고 사용자의 숫자는 Scanner클래스로 입력 받아 각각 int[]에 담습니다.
 * 사용자가 선택한 숫자의 값과 컴퓨터의 값을 비교해 값이 같고 배열 내의 index도 같은 경우 strike로 처리합니다.
 * 사용자가 선택한 숫자의 값과 컴퓨터의 값을 비교해 값은 같지만 배열 내의 index는 다른 경우 ball로 처리합니다.
 * strike와 ball이 하나도 없는 경우 "낫싱"으로 처리합니다.
 * 3strike면 게임이 종료됩니다.
 * 게임 종료 후 재게임 여부를 물어 1을 입력하면 게임을 다시 시작하고 2를 입력하면 게임을 종료합니다. 
 */

package com.woowa.precourse;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 야구게임을 구현한 클래스입니다.
 * 
 * @version    1.00 2019년 3월 26일
 * @author     노수진
 */
public class BaseballGame implements Baseball {
    Scanner sc = new Scanner(System.in);
    
    /** 상대방(컴퓨터)의 수 */
    protected int[] computerNums = new int[3]; 
    
    /** 입력받은 유저의 수 */
    protected int[] userNumbers = new int[3];
    
    /** strike와 ball 결과, index 0은 strike, 1은 ball */
    protected int[] result = new int[2];

    /**
     * 상대방(컴퓨터)의 1~9까지의 세 개의 정수를 생성하는 메서드
     *
     * @return 1~9까지의 서로 다른 세 개의 정수를 담은 int[] 
     */
    @Override
    public int[] makeThreeRandomNumbers() {
        Random random = new Random();
        boolean duplicate = true;

        /* 첫 번째 값 생성 */
        computerNums[0] = 1 + random.nextInt(9);

        /* 두 번째 값 생성 */
        while (duplicate) {
            computerNums[1] = 1 + random.nextInt(9);
            duplicate = checkDuplicate(computerNums, 1);
        }

        duplicate = true;

        /* 세 번째 값 생성 */
        while (duplicate) {
            computerNums[2] = 1 + random.nextInt(9);
            duplicate = checkDuplicate(computerNums, 2);
        }

        return computerNums;
    }

    /**
     * 사용자의 입력 값을 받는 메서드
     *
     * @return 1~9까지의 서로 다른 세 개의 정수를 담은 int[] 
     */
    @Override
    public int[] inputUserNumbers() {
        String inputNumber = "";

        boolean notValidated = true;
       
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = sc.nextLine();
            
            /** 입력 받은 값이 정수인지, 3자리인지, 중복하지 않는지 검사  */
            notValidated = checkInputNumbers(inputNumber);  
        } while (notValidated);

        return userNumbers;
    }
    
    /**
     * 사용자가 입력한 값의 유효성을 검사하는 메서드
     *
     * @param   사용자로부터 입력 받은 String값
     * @return  입력 받은 값이 1~9의 서로 다른 정수이고 3자리이면 false를 리턴 
     */
    @Override
    public boolean checkInputNumbers(String inputNumber) {
        boolean isNotValidate = true;
        boolean isDuplicate1 = true;
        boolean isDuplicate2 = true;
        boolean isNotAllNumber = true;
        boolean isNotThreeNumber = true;
        
        /* 입력 값이 1~9까지의 정수인지 확인 */
        isNotAllNumber = checkNumberOrNot(inputNumber);
        
        /* 입력 값이 3자리인지 확인 */
        isNotThreeNumber = checkInputNumberLength(inputNumber);

        if (isNotAllNumber == true || isNotThreeNumber == true) {
            return isNotValidate;
        }
        
        /* String으로 입력 받은 문자열을 int[]로 변환 */
        userNumbers = convertStringToIntArray(inputNumber);
        
        /* 두 번째 값 중복 확인 */
        isDuplicate1 = checkDuplicate(userNumbers, 1);
        
        /* 세 번째 값 중복 확인 */
        isDuplicate2 = checkDuplicate(userNumbers, 2);
        
        if (isDuplicate1 == false && isDuplicate2 == false) {
            isNotValidate = false;
        }
        
        return isNotValidate;
    }
    
    /**
     * 매개변수로 주어진 index에 위치한 값이 배열 내에서 중복값인지 확인하는 메소드
     *
     * @param  int[]   검사의 대상이 되는 int[]배열
     * @param  int     배열에서 검사의 기준이 되는 값의 index
     * @return boolean 중복값이 없을 경우 false, 중복값이 있을 경우 true 
     */
    @Override
    public boolean checkDuplicate(int[] intArray, int index) {
        boolean duplicate = false; 
        
        for (int i = 0; i < index; i++) {
            if (intArray[i] == intArray[index]) {
                duplicate = true;
                return duplicate;
            }
        }  // end for
        
        return duplicate;
    }

    /**
     * 인자로 받은 String값을 int[]로 변환하는 메서드
     *
     * @param Scanner로 입력 받은 String
     * @return String을 int[]로 변환한 값
     */
    @Override
    public int[] convertStringToIntArray(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            userNumbers[i] = (int)inputNumber.charAt(i)-48;
        }
        
        return userNumbers;
    }

    /**
     * 인자로 받은 String값이 1~9까지의 정수로만 이루어졌는지 확인하는 메서드
     *
     * @param Scanner로 입력 받은 String
     * @return 정수로만 이루어졌으면 false를 리턴
     */
    @Override
    public boolean checkNumberOrNot(String inputNumber) {
        boolean isNotAllNumber = false;
        
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) < 49 || inputNumber.charAt(i) > 57) {
                isNotAllNumber = true;
                return isNotAllNumber;
            } 
        }  // end for 
        
        return isNotAllNumber;
    }

    /**
     * 인자로 받은 String값의 길이가 3인지 확인하는 메서드
     *
     * @param Scanner로 입력 받은 String
     * @return boolean 길이가 3이면 false를 리턴
     */
    @Override
    public boolean checkInputNumberLength(String inputNumber) {
        boolean isNotThree = false;

        if (inputNumber.length() != 3) {
            isNotThree = true;
        } 

        return isNotThree;
    }

    /**
     * 컴퓨터의 int[]과 사용자의 int[]배열을 비교해 Stike인지 Ball인지 판별하는 메서드
     * 사용자의 배열 안에 있는 값과 컴퓨터의 배열 안에 있는 값의 index와 값이 모두 같으면 strike
     * 사용자의 배열 안에 있는 값과 컴퓨터의 배열 안에 있는 값이 같으나 index가 다를 경우 ball
     *
     * @param int[] 컴퓨터의 수를 담은 배열
     * @param int[] 사용자의 수를 담은 배열
     * @return int[] strike와 ball값을 담은 배열
     */
    @Override
    public int[] checkStrikeOrBall(int[] comNumbers, int[] userNumbers) {
        int[] strikeAndBall = new int[2];
        
        ArrayList<Integer> comNumList = new ArrayList<Integer>();
        comNumList.add(comNumbers[0]);
        comNumList.add(comNumbers[1]);
        comNumList.add(comNumbers[2]);
        
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == comNumbers[i]) {
                strikeAndBall[0] += 1;
            } else if (comNumList.contains(userNumbers[i])) {
                strikeAndBall[1] += 1;
            }  
        }   // end for  

        return strikeAndBall;
    }

    @Override
    public void runGame() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reGame() {
        // TODO Auto-generated method stub
        
    }
    
    public static void main(String[] args) {
        
    }

}