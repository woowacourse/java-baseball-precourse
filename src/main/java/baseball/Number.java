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

    public void setArrayNumberAt(int index, int number){
        this.numArray[index]=number;
        isUsed[number]=true;
    }

    public int getArrayNumberAt(int index){return this.numArray[index];}

    public boolean isUsedNumber(int number){
        return isUsed[number];
    }
}
