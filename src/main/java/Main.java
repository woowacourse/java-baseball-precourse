import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();

        ArrayList<Integer> target = new ArrayList<Integer>(3);         // 야구게임 시작 문제숫자를 추가할 리스트 선언
        while(target.size()!=3){
            int newNumber = random.nextInt(9) + 1;                         // 난수 생성
            if (target.contains(newNumber)) continue;                            // 생성된 난수가 이미 리스트에 존재할 경우 다시 난수 생성
            target.add(newNumber);                                               // 생성된 난수가 리스트에 존재하지 않으면 리스트에 추가
        }

    }
}
