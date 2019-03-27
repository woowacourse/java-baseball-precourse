import java.util.Arrays;

public class Baseball {

    private String computer_number, input_number;         //컴퓨터가 임의로 생성한 숫자, 사용자가 입력한 숫자
    private int strike_num, ball_num;           // strike 개수, ball 개수
    private boolean[] number_check = new boolean[10];           // 1~9까지 사용한 각 자리 숫자 확인을 위한 배열

    public Baseball(){
        computer_number = "";
        input_number = "";
        strike_num = 0;
        ball_num = 0;
        Arrays.fill(number_check, false);
    }

    // 기능 1
    public void runGame(){
        while(true){
            Arrays.fill(number_check, false);
            //TODO 기능 2: 임의의 세자리수 생성
            do{
                strike_num = 0;
                ball_num = 0;

                /*
                기능 3: 사용자 입력
                기능 4: strike, ball 개수 확인
                기능 5: 결과 print
                 */

            }while(strike_num < 3);

            /*
            기능 6: 새로시작 or 종료
             */
        }
    }
}
