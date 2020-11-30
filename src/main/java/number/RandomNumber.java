package number;

import utils.RandomUtils;

/**
 * @author junyoung.choi
 */
public class RandomNumber {

    int[] ranNum = new int[Constant.MAX_NUM];

    public RandomNumber(){
        makeRandomNumber();
    }

    public void makeRandomNumber(){
        boolean[] duplicateCheck = new boolean[10];

        for(int i=0;i<Constant.MAX_NUM;i++){
            int num = RandomUtils.nextInt(1,9);

            while(duplicateCheck[num]){
                num = RandomUtils.nextInt(1,9);
            }

            ranNum[i] = num;
            duplicateCheck[num] = true;
        }
    }

    public int[] getRandomNumber(){
        return ranNum;
    }
}
