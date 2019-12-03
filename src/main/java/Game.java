import utils.InputUtils;

public class Game {
    static final int RETRY=1;
    static final int EXIT=2;
    public static void main(String[] args) {
        do{
            new BaseballGame().run();
        }while(askRetry());
        InputUtils.closeInput();
    }
}