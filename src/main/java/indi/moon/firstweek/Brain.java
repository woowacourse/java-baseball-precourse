package indi.moon.firstweek;

import java.util.ArrayList;
import java.util.Arrays;

public class Brain extends Computer implements Brainface {

    public ArrayList[] getLearningData(
            int[] comnum, int[] result, ArrayList[] info,ArrayList number) {

        /* Default Setting */
        int[] countarr = {0};
        int[] totalCountarr = {0};
        info[4].add(countarr);
        info[5].add(totalCountarr);
        info[6].add(0);
        int countNum =((int[])info[4].get(0))[0];
        int totalcountNum =((int[])info[5].get(0))[0];
        info[2].add(comnum);
        info[3].add(result);
        ((int[])info[5].get(0))[0]++;
        number.remove((Integer)comnum[0]);
        number.remove((Integer)comnum[1]);
        number.remove((Integer)comnum[2]);

        /* state Learning */
        switch((Integer)info[6].get(0)) {
            case 1:
                info = learnState2S(info,result,number);
                return info;
            case 2 :
                info = learnState1S1B(info,result,number,comnum);
                return info;
            case 3 :
                info = learnState0S2B(info,result,number,comnum);
                break;
            case 4 :
                info = learnState1S0B(info,result,number,comnum);
                return info;
            case 5 :
                info = learnState0S1B(info,result,comnum);
                break;
            case 6 :
                info = learnState1S2B(info,comnum);
            default :
                learnOut(info,number,result);
                break;
        }

        /* basic Learning */
        if(result[0]==1 && result[1] ==2) {
            info[6].clear();
            info[6].add(6);
            loop1S1B(info,comnum);
            return info;
        }

        if(result[0]==2 && result[1] ==0) {
            loop2S0B(info,number,comnum);
            ((int[])info[4].get(0))[0] = 0;
            return info;
        }

        if(result[0]==1 && result[1] ==1) {
            info[6].clear();
            info[6].add(2);
            loop1S1B(info,comnum);
            ((int[])info[4].get(0))[0] = 0;
            return info;
        }

        if(result[0]==0 && result[1] ==2) {
            info[6].clear();
            info[6].add(3);
            loop0SNB(info,comnum);
            ((int[])info[4].get(0))[0]++;
            return info;
        }

        if(result[0]==1 && result[1] ==0) {
            info[6].clear();
            info[6].add(4);
            loop1S0B(info,number,comnum);
            ((int[])info[4].get(0))[0] = 0;
        }

        if(result[0]==0 && result[1] ==1) {
            info[6].clear();
            info[6].add(5);
            loop0SNB(info,comnum);
        }

        if(result[0]==0 && result[1] ==0) {
            loopOut(info,number);
        }
        return info;
    }

    public int[] getData(ArrayList[] info) {
        int[] arr = new int[3];
        if(info[1].size()>0) {
            arr[0] = ((int[])info[1].get(0))[0];
            arr[1] = ((int[])info[1].get(0))[1];
            arr[2] = ((int[])info[1].get(0))[2];
        }else if(info[0].size()>0) {
            arr[0] = (Integer)info[0].get(0);
            arr[1] = (Integer)info[0].get(1);
            arr[2] = (Integer)info[0].get(2);
            info[0].clear();
        }else {
            System.out.println("에러");
        }
        return arr;
    }
//////////////////////////////////////////////////////////////////////

    /**
     * 루프
     */



    public void loopReset2S0B(ArrayList[] info,ArrayList number) {
        int[] tmp1 = {((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[0],((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[1],(int)number.get(0)};
        int[] tmp2 = {(int)number.get(0),((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[1],((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[2]};
        int[] tmp3 = {((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[0],(int)number.get(0),((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[2]};
        info[1].add(tmp1);
        info[1].add(tmp2);
        info[1].add(tmp3);
    }

    public void loopReset1S0B(ArrayList[] info,ArrayList number) {
        int[] tmp1 = {((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[0],(int)number.get(0),(int)number.get(1)};
        int[] tmp2 = {(int)number.get(0),((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[1],(int)number.get(1)};
        int[] tmp3 = {(int)number.get(0),(int)number.get(1),((int[])info[2].get((((int[])info[5].get(0))[0])-(((int[])info[4].get(0))[0])-1))[2]};
        info[1].add(tmp1);
        info[1].add(tmp2);
        info[1].add(tmp3);
    }
    public void loop2S0B(ArrayList[] info,ArrayList number,int[] comnum) {
        int[] tmp1 = {comnum[0],comnum[1],(int)number.get(0)};
        int[] tmp2 = {(int)number.get(0),comnum[1],comnum[2]};
        int[] tmp3 = {comnum[0],(int)number.get(0),comnum[2]};
        info[1].add(tmp1);
        info[1].add(tmp2);
        info[1].add(tmp3);
    }
    public void loop1S1B(ArrayList[] info, int[] comnum) {
        int[] tmp1 = {comnum[0],comnum[2],comnum[1]};
        int[] tmp2 = {comnum[2],comnum[1],comnum[0]};
        int[] tmp3 = {comnum[1],comnum[0],comnum[2]};
        info[1].add(tmp1);
        info[1].add(tmp2);
        info[1].add(tmp3);
    }
    public void loop1S0B(ArrayList[] info,ArrayList number,int[] comnum){
        int[] tmp1 = {comnum[0],(int)number.get(0),(int)number.get(1)};
        int[] tmp2 = {(int)number.get(0),comnum[1],(int)number.get(1)};
        int[] tmp3 = {(int)number.get(0),(int)number.get(1),comnum[2]};
        info[1].add(tmp1);
        info[1].add(tmp2);
        info[1].add(tmp3);
    }
    public void loop0SNB(ArrayList[] info, int[] comnum) {
        info[0].add(comnum[1]);
        info[0].add(comnum[2]);
        info[0].add(comnum[0]);
    }
    public void loopOut(ArrayList[] info,ArrayList number){
        info[0].add(number.get(0));
        info[0].add(number.get(1));
        info[0].add(number.get(2));
    }

    /**
     * 상황별 학습
     */

    public static ArrayList[] learnState1S2B(ArrayList[] info, int[] comnum) {
        info[1].remove(0);
        return info;
    }

    public ArrayList[] learnState2S(ArrayList[] info, int[] result, ArrayList number){
        if(result[0]+result[1] == 1) {
            info[1].clear();
            ((int[])info[4].get(0))[0]++;
            loopReset2S0B(info, number);
            return info;
        }

        if(info[1].size()>0) {
            info[1].remove(0);
            ((int[])info[4].get(0))[0]++;
            return info;
        }else {
            loopReset2S0B(info, number);
            return info;
        }
    }

    public ArrayList[] learnState1S1B(ArrayList[] info, int[] result, ArrayList number,int[] comnum){
        if(result[0]!=2) {
            info[1].remove(0);
//				//Count 카운트 상승
//				((int[])info[4].get(0))[0]++;
            return info;
        }else {
            info[6].clear();
            info[1].clear();
            if(result[0]==2 && result[1] ==0) {
                info[6].clear();
                info[6].add(1);
                //1로 이동
                loop2S0B(info,number,comnum);
                ((int[])info[4].get(0))[0] = 0;
                return info;
            }
        }
        return info;
    }

    public ArrayList[] learnState0S2B(ArrayList[] info, int[] result, ArrayList number,int[] comnum){
        if(result[0]==2) {
            info[6].clear();
            info[1].clear();
            if(result[0]==2 && result[1] ==0) {
                info[6].clear();
                info[6].add(1);
                //1로 이동
                loop2S0B(info,number,comnum);
                ((int[])info[4].get(0))[0] = 0;
                return info;
            }
        }
        if(((int[])info[4].get(0))[0] >3) {
            //TB에 값을 넣어 반복
            info[0].add(comnum[2]);
            info[0].add(comnum[1]);
            info[0].add(comnum[0]);
            //Count 초기화
            ((int[])info[4].get(0))[0] = 0;
            return info;
        }
        return info;
    }

    public ArrayList[] learnState1S0B(ArrayList[] info, int[] result, ArrayList number,int[] comnum){
        if(result[0]+result[1]==0) {
            info[1].clear();
            ((int[])info[4].get(0))[0]++;
            loopReset1S0B(info,number);
            return info;
        }
        if(result[0]+result[1]>=2) {
            info[6].clear();
            info[1].clear();
            if(result[0]==2 && result[1] ==0) {
                info[6].clear();
                info[6].add(1);
                loop2S0B(info,number,comnum);
                ((int[])info[4].get(0))[0] = 0;
                return info;
            }else if(result[0]==1 && result[1] ==1) {
                info[6].clear();
                info[6].add(2);
                loop1S1B(info,comnum);
                ((int[])info[4].get(0))[0] = 0;
                return info;
            }else {
                info[6].clear();
                info[6].add(3);
                loop0SNB(info,comnum);
                ((int[])info[4].get(0))[0]++;
                return info;
            }
        }else {
            if(info[1].size()>0) {
                info[1].remove(0);
                ((int[])info[4].get(0))[0]++;
                return info;
            }else {
                loopReset1S0B(info,number);
                return info;
            }
        }
    }

    public ArrayList[] learnState0S1B(ArrayList[] info, int[] result,int[] comnum){
        if(result[0]==1) {
            info[6].clear();
        }else {
            info[0].add(comnum[1]);
            info[0].add(comnum[2]);
            info[0].add(comnum[0]);
        }
        return info;
    }

    public ArrayList[] learnOut(ArrayList[] info, ArrayList number, int[] result){
        if(result[0]==0 && result[1] ==0) {
            loopOut(info,number);

        }
        return info;
    }

}
