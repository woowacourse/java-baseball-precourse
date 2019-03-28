package indi.moon.firstweek;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Computer extends Config implements Computerface {
    int[] result = {0,0,0};
    int[] countarr = {0};
    int[] totalCountarr = {0};
    ArrayList<int[]> TB = new ArrayList<int[]>();
    ArrayList<int[]> TS = new ArrayList<int[]>();
    ArrayList<int[]> Pre = new ArrayList<int[]>();
    ArrayList<int[]> resultedLog = new ArrayList<int[]>();
    ArrayList<int[]> count = new ArrayList<int[]>();
    ArrayList<int[]> totalCount = new ArrayList<int[]>();
    ArrayList<int[]> state = new ArrayList<int[]>();
    ArrayList number = new ArrayList();

    ArrayList []info = {TB,TS,Pre,resultedLog,count,totalCount,state};

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
}
