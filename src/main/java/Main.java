import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Random random = new Random();

        ArrayList<Integer> targetList = new ArrayList<Integer>(3);  // 야구게임 시작 문제숫자를 추가할 리스트 선언
        while(targetList.size()!=3){
            int newNumber = random.nextInt(9) + 1;  // 난수 생성
            if (targetList.contains(newNumber)) continue;  // 생성된 난수가 이미 리스트에 존재할 경우 다시 난수 생성
            targetList.add(newNumber);  // 생성된 난수가 리스트에 존재하지 않으면 리스트에 추가
        }

        Scanner sc = new Scanner(System.in);
        int userNumber = sc.nextInt();  // 사용자의 입력을 받는 부분
        ArrayList<Integer> userList = new ArrayList<Integer>(3);  // 사용자의 숫자를 리스트 형태로 바꾸는 부분
        userList.add(0,userNumber / 100);  // 첫번째 숫자 추가
        userList.add(1,userNumber %100 / 10);  // 두번째 숫자 추가
        userList.add(2,userNumber %100 %10);  // 세번째 숫자 추가


        int ballNumber = 0;  // 볼 변수 선언
        for(int user : userList){
            if(targetList.contains(user)){
                ballNumber++;  // 사용자리스트의 값이 타겟리스트에 존재하면 볼 변수 증가
            }
        }

        int strikeNumber = 0;  // 스트라이크 변수 선언
        for(int i = 0; i<3;i++){
            if (targetList.get(i) == userList.get(i)){
                strikeNumber++;  // 사용자리스트와 타겟리스트의 같은 인덱스의 값을 비교하여 같으면 스트라이크 변수 증가
            }
        }
        ballNumber -= strikeNumber;  // 볼 변수에 스트라이크 변수가 포함되기 때문에 스트라이크 변수만큼 감소

    }
}
