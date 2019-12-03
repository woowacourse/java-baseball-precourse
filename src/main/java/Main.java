import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        boolean playing = true;
        int num_len = 3;
        Scanner scan = new Scanner(System.in);
        String askReplay = "게임을 새로 시작하려면 1,"
                + " 종료하려면 2를 입력하세요.";


        while (playing){
            Game new_game = new Game(num_len);
            new_game.playBaseball();
            System.out.println(askReplay);
            int answer = Integer.parseInt(scan.next().trim());
            if(answer == 1){
                playing = false;
            }
        }
        scan.close();
    }
}
