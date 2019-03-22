import java.util.Random;

class Game {
    private String[] answer = new String[3];

    public Game() {
        answer = generateAnswer();
    }

    private String[] generateAnswer() {
        String[] str = new String[3];
        Random random = new Random();

        for (int i = 0; i < str.length; i++) {
            int num = random.nextInt(9) + 1;
            str[i] = String.valueOf(num);
        }

        return str;
    }
}

public class Baseball {
    public static void main(String[] args) {
        Game game = new Game();
    }
}
