package baseball;


import java.util.Scanner;

public class Player {
    boolean[] checkNumberDuplicated = new boolean[Constants.MAX_RANGE];
    int[] numbers;

    public void Player(){

    }

    public void inputThreeNumbers(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            String input = sc.nextLine();
            if(true){ //true 대신 유효성 검증 부분 추가
                throw new IllegalArgumentException("1~9 사이의 수로 이루어진 서로 다른 세 자리 수만 입력 가능합니다.");
            } else {
                // input을 Integer Array로 변경하는 로직 추가
                break;
            }
        }
    }
}
