import java.util.Scanner;
import java.util.Random;

public class baseball{
    public static void baseball_game(){
        int answer, state=1;
        answer = baseball.makeanswer(); // 컴퓨터의 정답
        System.out.println("난수 생성 완료.");
        Scanner scan = new Scanner(System.in);
        while(state==1) {
            int input;
            System.out.print("숫자를 입력해주세요 : ");
            input = scan.nextInt();
            state = baseball.match_check(answer, input);
        }
    }
    public static void main(String[] args){
        int keep_going = 1;
        Scanner scan = new Scanner(System.in);
        do{
            baseball.baseball_game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            keep_going = scan.nextInt();
        } while(keep_going==1);

    }
}