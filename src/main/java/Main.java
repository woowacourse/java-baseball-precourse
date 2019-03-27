import java.io.IOException;

public class Main {

    // 메인 함수
    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        try {
            playGame.startGame();
        } catch (IOException e) {
            // BufferedReader 에서 파일 읽어올때 생기는 예외 처리 IOException 예외 처리문
            System.out.println(ErrorMessage.IOEXCEPTION_ERROR.getErrorMessage());
        }
    }
}
