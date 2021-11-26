package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    //맞춰야 할 숫자
    public int[] target = new int[3];

    //Computer 인스턴스 생성시 target 만들어짐
    public Computer(){
        LinkedHashSet<Integer> targetSet = new LinkedHashSet<>();

        while(targetSet.size()<3){
            targetSet.add(pickNumberInRange(1,9));
        }
        Iterator iter = targetSet.iterator();
        int i=0;
        while(iter.hasNext()){
            target[i++]= (int) iter.next();
        }

    }
}