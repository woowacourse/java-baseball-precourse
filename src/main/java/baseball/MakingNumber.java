package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class MakingNumber {
    //숫자야구의 시작과 끝 범위.
    final static int START_NUM = 1;
    final static int END_NUM = 9;
    private ArrayList<Integer> target = new ArrayList<>(Application.LENGTH);

    //target에 element 중복을 체크하는 함수.
    private void IsUsed(int element) throws IllegalArgumentException{
        if(target.contains(element)){
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요!");
        }
    }

    //Computer가 사용할 땐, 예외를 넘길 필요가 없으니까.
    private boolean comUsed(int element){
        if(!target.contains(element)){
            return true;
        }
        return false;
    }

    private void checkRange(int element)throws IllegalArgumentException{
        if(END_NUM <element || element < START_NUM) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력이 가능합니다!");
        }
    }

    private void checkLength() throws IllegalArgumentException{
        //3자리 수를 입력하지 않았을 때, 오류 throw
        if(this.target.size() != Application.LENGTH)
            throw new IllegalArgumentException("3자리수를 입력했는지 확인해주세요!");
    }

    //target을 만든다(임의의 수 버전)
    MakingNumber(){
        while(target.size() < Application.LENGTH){
            int element = RandomUtils.nextInt(START_NUM, END_NUM);
            if(comUsed(element)){
                this.target.add(element);
            }
        }
    }
    //target을 만든다(사용자 버전)
    MakingNumber(String answer) throws IllegalArgumentException{
        //arraylist로 변환.
        System.out.println(answer);
        for(int i = 0; i<answer.length();i++){
            int element =answer.charAt(i) - '0';
            //전에 쓴 적이 있으면, throw
            IsUsed(element);
            //범위가 벗어나면, false.
            checkRange(element);
            //값을 넣을 때마다 0에 있던 숫자는 한칸 뒤로 감.
            this.target.add(element);
        }
        checkLength();

    }


    //private한 target return 하는 함수.
    protected ArrayList<Integer> getTarget(){
        return this.target;
    }
}
