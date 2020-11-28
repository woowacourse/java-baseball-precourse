package baseball;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Number {
    private int[] numArray;

    public Number(int size){
        numArray= new int[size];
    }

    public void setArrayNumberAt(int index, int number){this.numArray[index]=number;}

    public int getArrayNumberAt(int index){return this.numArray[index];}
}
