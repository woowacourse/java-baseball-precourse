package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class MakeNumber {
    //숫자야구의 시작과 끝 범위.
    final static int StartNum = 1;
    final static int EndNum = 9;
    //사용자가 세자리 수를 입력하는지 확인하는 변수.
    final static int UserInputLimit = 100;
    private ArrayList<Integer> target = new ArrayList<>(Application.LENGTH);

    //target에 element 중복을 체크하는 함수.
    private void IsUsed(int element) throws IllegalArgumentException{
        if(target.contains(element)){
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요!");
        }
    }

    //Computer가 사용할 땐, 예외를 넘길 필요가 없으니까.
    private boolean AmUsed(int element){
        if(!target.contains(element)){
            return true;
        }
        return false;
    }

    private void CheckRange(int element)throws IllegalArgumentException{
        if(EndNum<element || element < StartNum) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력이 가능합니다!");
        }
    }

    private void CheckLength(int answer) throws IllegalArgumentException{
        //3자리 수를 입력하지 않았을 때, 오류 throw
        if(answer < UserInputLimit){
            //ex) 012입력할 때, 3자리수를 입력했는지 확인하라고 함.
            throw new IllegalArgumentException("첫째자리에 0을 썼는지, 또는 3자리 수를 입력했는지 확인해주세요");
        }
    }

    //target을 만든다(임의의 수 버전)
    MakeNumber(){
        while(target.size() < Application.LENGTH){
            int element = RandomUtils.nextInt(StartNum, EndNum);
            if(AmUsed(element)){
                this.target.add(element);
            }
        }
    }
    //target을 만든다(사용자 버전)
    MakeNumber(int answer) throws IllegalArgumentException{
        CheckLength(answer);
        //arraylist로 변환.
        while(answer > 0){
            int element = answer % 10;
            //전에 쓴 적이 있으면, throw
            IsUsed(element);
            //범위가 벗어나면, false.
            CheckRange(element);
            //값을 넣을 때마다 0에 있던 숫자는 한칸 뒤로 감.
            this.target.add(0,element);

            answer = answer / 10;
        }

    }


    //private한 target return 하는 함수.
    protected ArrayList<Integer> GetTarget(){
        return this.target;
    }
}
