import java.io.IOException;

public class Main {

    // 메인 함수
    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        try {
            playGame.startGame();
        } catch (IOException e) {
            System.out.println(ErrorMessage.IOEXCEPTION_ERROR.getErrorMessage());
        }
    }
}
