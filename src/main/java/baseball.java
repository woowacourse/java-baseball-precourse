import java.util.Scanner;
import java.util.Random;

public class baseball{
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