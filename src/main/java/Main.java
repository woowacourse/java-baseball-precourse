public class Main {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        for (int i = 0; i < 3; i++) {
            System.out.println((baseball.computer[i]));
        }

        baseball.getUserInput();

        for (int j = 0; j < 3; j++) {
            System.out.println(baseball.user[j]);
        }
    }
}
