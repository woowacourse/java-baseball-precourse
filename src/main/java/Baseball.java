/*
 * 이 클래스틑 Baseball 게임에 대한 클래스로 게임 진행을 위한 메소드와 인스턴스가 있다
 * README.MD 에 작성한 기능별로 메소드가 있다
 *
 * 클래스 이름    Baseball
 *
 * 버전 정보     1.0
 *
 * 날짜    2019/03/27
 *
 * 저작권   권유상
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
            computer_number = generateNumber();
            do{
                strike_num = 0;
                ball_num = 0;
                input_number = input();
                strikeBallCheck(computer_number, input_number);
                print();
            }while(strike_num < 3);

            if(isFinish()){
                break;
            }
        }
    }

    // 기능 2
    private String generateNumber() {
        String ret = "";        //리턴할 3자리 숫자
        int random_number;
        Random random = new Random();

        /* 전체 숫자의 길이가 3일때 까지 1~9까지 숫자를 하나씩 생성 */
        do {
            random_number = random.nextInt(8) + 1;
            // 중복 확인
            if(ret.contains(Integer.toString(random_number))) {
                continue;
            }
            ret += Integer.toString(random_number);
            number_check[random_number] = true;
        }while(ret.length() < 3);

        return ret;
    }

    // 기능 3 - 1
    private String input() {
        String ret ="";         // 리턴할 입력받은 3자리 숫자
        while(true) {
            System.out.print("숫자를 입력해 주세요: ");
            Scanner scan = new Scanner(System.in);
            ret = scan.nextLine();
            if(isValidInput(ret)) {
                break;
            }
            else {
                System.out.println("올바르지 않은 입력입니다. 3자리 중복 없는 숫자로 입력해주세요");
            }
        }
        return ret;
    }

    // 기능 3 - 2
    private boolean isValidInput(String str){

        /* 3자리수가 아니면 false */
        if(str.length() != 3) {
            return false;
        }

        /* 임시 string 변수 temp에 str의 숫자를 하나씩 옮기면서 중복확인 */
        String temp = "";
        for(int i = 0; i < 3; i++) {
            if(temp.contains(String.valueOf(str.charAt(i)))) {
                return false;
            }
            else {
                temp += str.charAt(i);
            }
        }

        return true;
    }

    //기능 4
    private void strikeBallCheck(String answer, String number) {

        /* 맞힐 숫자(answer)와 입력한 숫자(number)를 한자리씩 비교하며 strike와 ball의 개수를 count up */
        for(int i = 0; i < 3; i++) {
            if(answer.charAt(i) == number.charAt(i)) {
                strike_num++;
            }
            else if(number_check[number.charAt(i) - '0']) {
                ball_num++;
            }
        }
    }

    //기능 5
    private void print() {
        if(strike_num > 0 && ball_num > 0) {
            System.out.println(strike_num + "스트라이크 " + ball_num + " 볼");
        }
        else if(strike_num > 0) {
            System.out.println(strike_num + "스트라이크 ");
        }
        else if(ball_num > 0) {
            System.out.println(ball_num + " 볼");
        }
        else {
            System.out.println("낫싱");
        }
    }

    //기능 6
    private boolean isFinish() {
        int finish;         // 입력받을 숫자를 저장
        Scanner scan = new Scanner(System.in);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        while(true) {
            finish = scan.nextInt();
            if(finish == 1) {
                return false;
            }
            else if(finish == 2) {
                return true;
            }
            else {
                System.out.print("Error, 1 또는 2를 입력해주세요: ");
                continue;
            }
        }
    }
}
