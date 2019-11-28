import java.util.Scanner;
public class Baseball {

    static int randomdata[] = {0,0,0};
    static int user[] = {0,0,0};

    // 실질적 게임을 작동하는 함수
    static int game(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            int n = sc.nextInt();
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int n = sc.nextInt();
        return n;
    }
    public static void main(String[] args) {
        int n = 1;
        while (n == 1){
            // depth 1
            n = game();
        }
    }
}
