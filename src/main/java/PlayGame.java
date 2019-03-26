import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PlayGame {

    public void startGame() {

        HashMap hashMap;
        String[] playerNum;
        int gameResult = 0;

        System.out.println("숫자 야구게임을 시작합니다.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            hashMap = Number.getInstance().comNum();
            do {
                playerNum = Number.getInstance().playerNum(br);
                gameResult = Feature.getInstance().checkNum(hashMap, playerNum);
            } while (gameResult != 3);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        } while (isExit(br));

    }

    // 새게임, 종료 물어보는 함수
    private boolean isExit(BufferedReader br) {
        try {
            String exitNum = br.readLine();
            if (exitNum.equals("1")) {
                return true;
            } else if (exitNum.equals("2")) {
                return false;
            } else {
                // 다른 문자가 올경우 예외처리
                System.out.println(ErrorMessage.OTHER_NUMBER_ERROR.getErrorMessage());
                return isExit(br);
            }
        }catch (IOException e){
            System.out.println(ErrorMessage.IOEXCEPTION_ERROR.getErrorMessage());
            return isExit(br);
        }
    }

}
