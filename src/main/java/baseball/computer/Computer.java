package baseball.computer;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    //맞춰야 할 숫자
    public Integer[] target = new Integer[3];

    //target 숫자를 만드는 함수
    public void makeTarget(){

        target[0]=pickNumberInRange(1,9);

        for (int i=1;i<3;i++){
            //주어진 메소드를 활용하여 1~9사이의 수를 랜덤으로 불러온다
            Integer number=pickNumberInRange(1,9);
            if (target[i-1]==number){
                i--;
                continue;
            }
            target[i]=number;
        }

    }
}