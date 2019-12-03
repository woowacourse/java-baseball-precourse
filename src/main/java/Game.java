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
    static boolean askRetry(){
        boolean result=false;
        while (true) {
            int input = InputUtils.inputInteger(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n", RETRY,EXIT));
            if (input==RETRY || input==EXIT) {
                result = input==RETRY;
                break;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
        return result;
    }
}