import java.util.Scanner;

public class Main {
    private static Computer computer = new Computer();
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean on_game = true; // 게임 추가 진행 플래그
        while (on_game) {
            play();
            on_game = ask_retry();
        }
        sc.close();
    }

    private static void play() {
        computer.make_answer();
        int suggested_answer;
        boolean success = false;
        while (!success) {
            System.out.print("숫자를 입력해주세요 :\n");
            suggested_answer = sc.nextInt();
            success = computer.compare_answer(suggested_answer); // 정답을 맞추면 탈출
        }
    }

    private static boolean ask_retry() {
        int retry_answer;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        retry_answer = sc.nextInt();
        return retry_answer == 1;
    }
}
