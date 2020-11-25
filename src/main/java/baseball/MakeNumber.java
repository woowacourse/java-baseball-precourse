package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

//같은 package 내에서만 가능.
class MakeNumber {
    private ArrayList<Integer> target = new ArrayList<>();

    //target에 element 중복을 체크하는 함수.
    private boolean IsUsed(int element){
        if(!target.contains(element)){
            return true;
        }
        else{
            return false;
        }
    }

    //target을 만든다.
    MakeNumber(){
        while(target.size() < Application.LENGTH){
            int element = RandomUtils.nextInt(1, 9);
            if(IsUsed(element)){
                target.add(element);
            }
        }
    }

    //private한 target return 하는 함수.
    protected ArrayList<Integer> GetTarget(){
        return this.target;
    }
}
