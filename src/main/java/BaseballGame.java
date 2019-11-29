public class BaseballGame {
    public static void main(String[] args) {
        Computer com = new Computer();
        com.getRandom();

        User player = new User();
        player.inputNumber();
    }
}