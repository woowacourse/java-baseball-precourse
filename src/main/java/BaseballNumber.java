/*
 * 클래스 이름 : BaseballNumber
 * 클래스 설명 : 야구게임에 쓰이는 숫자 정보를 담고 있는 클래스이다.
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/12/01
 * Copyright (c) 2019 Moonyoung Chae
 */

class BaseballNumber {
    private final int NUMBER_SIZE = 3;
    private int number[] = new int[NUMBER_SIZE];

    public int[] getNumber(){
        return number;
    }

    public void setNumber(int inputNumber){
        for(int i = NUMBER_SIZE; i > 0; i--){
            number[i - 1] = inputNumber % 10;
            inputNumber /= 10;
        }
    }

    // 조건에 맞는 숫자인지 확인하는 함수
    public boolean checkNumber(int inputNumber){
        if(inputNumber / 100 > 10)
            return false;
        for(int i = NUMBER_SIZE; i > 0; i--){
            if(inputNumber % 10 == 0)
                return false;
            inputNumber /= 10;
        }
        return true;
    }
}
