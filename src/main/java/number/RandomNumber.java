package number;

import utils.RandomUtils;

/**
 * @author junyoung.choi
 */
public class RandomNumber {

    int[] ranNum = new int[3];

    public RandomNumber(){
        makeRandomNumber();
    }

    public void makeRandomNumber(){
        boolean[] duplicateCheck = new boolean[10];

        for(int i=0;i<3;i++){
            int num = RandomUtils.nextInt(0,9);

            while(duplicateCheck[num]){
                num = RandomUtils.nextInt(0,9);
            }

            ranNum[i] = num;
            duplicateCheck[num] = true;
        }
    }

    public int[] getRandomNumber(){
        return ranNum;
    }
/*
    테스트를 위하여 생성

    public String getTestNumber(){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<3;i++){
            sb.append(ranNum[i] + "");
        }

        return sb.toString();
    }
 */
}