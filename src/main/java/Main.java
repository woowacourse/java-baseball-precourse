import java.util.Scanner;

public class Main {
    static Baseball baseball = new Baseball();
    public static void main(String[] args) {

        baseball.init();
        while(retry()) {
            baseball.init();
        }
    }

    private static boolean retry() {
        System.out.println("다시 할까요? (Y/N)");
        Scanner sc = new Scanner(System.in);
        String decision = sc.nextLine();
        System.out.println(decision);
        if(decision.equals("Y") || decision.equals("y")) {
            System.out.println(decision);
            return true;
        }
        return false;
    }
}
