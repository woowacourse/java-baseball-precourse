package baseball;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Defender {
    private static Set<Integer> availableSet;
    private int number;
    public static Defender getInstance(){
        int num =0;
        if(availableSet==null){
            availableSet = initAvailableNumber();
             System.out.println("availableSet init");
        }
        while(!availableSet.contains(num)){
            num = pickNumberInRange(123,987);
        }
        System.out.println("set Number :" + num);
        return new Defender(num);
    }

    private Defender(int number){ this.number = number; }
    public int getNumber(){ return number; }

    private static Set<Integer> initAvailableNumber(){
        Set<Integer> initSet = new HashSet<>();
        char[] c;
        Set<Character> set;
        StringBuilder sb;
        boolean flag;
        for(int i=123; i<=987; i++){
            c = (""+i).toCharArray();
            set = new HashSet<>();
            sb = new StringBuilder();
            flag = true;
            for(int j=0; j<3; j++){
                if(c[j]=='0' || !set.add(c[j])) {
                    flag = false;
                    break;
                }
                sb.append(c[j]);
            }
            if(flag) {
                initSet.add(Integer.parseInt(sb.toString()));
            }
        }
        return initSet;
    }
}
