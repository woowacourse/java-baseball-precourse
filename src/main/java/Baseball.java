/*
 * Baseball Class
 * @version 1.0
 * @author ohsang seo
 */
public class Baseball {
    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        boolean restart = true;
        while (restart) {
            restart = baseballGame();
        }
        System.out.println("게임을 종료합니다.");
    }

    public static boolean baseballGame() {
        return false;
    }
}
