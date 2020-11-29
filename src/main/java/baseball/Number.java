package baseball;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Number {
    private int[] numArray;
    private boolean[] isUsed;

    public Number(int size){
        numArray= new int[size];
        isUsed=new boolean[10];
        for(int i=0;i<10;i++)
            isUsed[i]=false;
    }

    public void setNumberAt(int index, int number){
        this.numArray[index]=number;
        isUsed[number]=true;
    }

    public int getNumberAt(int index){return this.numArray[index];}

    public boolean isUsedNumber(int number){
        return isUsed[number];
    }

    /* 해당 객체에 number값을 가진 원소의 위치를 반환하는 메서드 */
    public int findNumber(int number){
        for(int i=0;i<numArray.length;i++)
            if(numArray[i]==number){
                //number값의 원소를 반환
                return i;
            }
        //number와 일치하는 원소가 없다면 -1을 반환
        return -1;
    }
}
