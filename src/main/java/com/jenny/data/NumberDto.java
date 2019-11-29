package com.jenny.data;

public class NumberDto {

    private int[] num = new int[3];

    public NumberDto(int number){
        num[0] = number/100;
        num[1] = number%100/10;
        num[2] = number*10;
    }

    public int[] getNum() {
        return num;
    }

    public void setNum(int[] num) {
        this.num = num;
    }
}
