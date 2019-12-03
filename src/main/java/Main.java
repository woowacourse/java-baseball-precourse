import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        boolean playing = true;
        Scanner scan = new Scanner(System.in);
        int num_len = 3;
        String askReplay = "게임을 새로 시작하려면 1,"
                + " 종료하려면 2를 입력하세요.";


        while (playing){
            Game new_game = new Game(num_len);
            new_game.playBaseball();
            System.out.println(askReplay);
            playing = Boolean.parseBoolean(scan.nextLine().trim());
        }

        scan.close();
    }
}
