package service;

import domain.Computer;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    private Computer computer = new Computer();

    public void initBaseballGame(){
        computer.setCoumputerNum(getRandomNumbers(1, 9));
        computer.initBallCount();

        int[] num = new int[3];
        num = computer.getCoumputerNum();
        for(int i= 0; i < 3; i ++){
            System.out.print(num[i]);
        }

    }

    public int[] getRandomNumbers(int start, int end){
        int[] nums = new int[3];

        for(int i= 0; i < 3; i++){
            nums[i] = Randoms.pickNumberInRange(start, end);
        }

        return nums;
    }

    public int getUniqueNumber(int[] nums, int start, int end, int i){
        int num = Randoms.pickNumberInRange(start, end);
        while(compareNums(nums, i))
            num = Randoms.pickNumberInRange(start, end);

        return num;
    }

    public boolean compareNums(int[] nums, int i){
        for(int j = 0; j < i; j++)
            if(nums[i] == nums[j])
                return false;
        return true;
    }


}
