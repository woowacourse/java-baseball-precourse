import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Game{

}

public class Main {
    public static void main(String[] args){
        Random random = new Random();

        ArrayList<Integer> targetList = new ArrayList<Integer>(3);         // 야구게임 시작 문제숫자를 추가할 리스트 선언
        while(targetList.size()!=3){
            int newNumber = random.nextInt(9) + 1;                             // 난수 생성
            if (targetList.contains(newNumber)) continue;                            // 생성된 난수가 이미 리스트에 존재할 경우 다시 난수 생성
            targetList.add(newNumber);                                               // 생성된 난수가 리스트에 존재하지 않으면 리스트에 추가
        }

        Scanner sc = new Scanner(System.in);
        int userNumber = sc.nextInt();                                               // 사용자의 입력을 받는 부분
        ArrayList<Integer> userList = new ArrayList<Integer>(3);          // 사용자의 숫자를 리스트 형태로 바꾸는 부분
        userList.add(0,userNumber / 100);
        userList.add(1,userNumber %100 / 10);
        userList.add(2,userNumber %100 %10);



    }
}
