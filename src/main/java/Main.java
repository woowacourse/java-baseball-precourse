import java.util.*;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        while(true) {
            Scanner s = new Scanner(System.in);
            Batter computer = new Batter();
            Pitcher user;
            int n;

            System.out.print("숫자를 입력해 주세요 : ");

            n = s.nextInt();
            user = new Pitcher(n);

            while (computer.game(user) != true) {
                System.out.print("숫자를 입력해 주세요 : ");
                n = s.nextInt();
                user = new Pitcher(n);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요");
            int cont = s.nextInt();
            if (cont == 1) {
                continue;
            } else return;
        }


    }
}
