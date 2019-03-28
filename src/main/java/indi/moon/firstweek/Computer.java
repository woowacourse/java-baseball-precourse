package indi.moon.firstweek;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Computer extends Config implements Computerface {

    @Override
    public int[] makeRandomNum(){
        String str = "";
        int[] tmp = new int [3];
        for(int i = 0; i<3; i++){
            int num = (int)(Math.random() * 10);
            num = exceptEx(num, i, tmp);
            str += num;
        }
        int[] arraynum = makeNumArray(str);
        return arraynum;
    }

    @Override
    public int exceptEx(int num, int i, int[] tmp){
        tmp[i] = num;
        if(num == 0){
            num = (int)(Math.random() * 10);
            exceptEx(num, i,tmp);
        }
        for(int k=0; k<i; k++){
            if(tmp[i] == tmp[k]){
                num = (int)(Math.random() * 10);
                exceptEx(num,i,tmp);
            }
        }
        return tmp[i];
    }

    public void lookComNum(int [] arr){
        String str = arr[0]+""+arr[1]+""+arr[2];
        System.out.println("컴퓨터의 입력값: \n"+str);
    }
}
