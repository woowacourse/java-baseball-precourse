import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PlayGame {

    public void startGame() throws IOException {

        HashMap hashMap;
        String[] playerNum;
        int gameResult;

        System.out.println("숫자 야구게임을 시작합니다.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hashMap = Number.getInstance().comNum();

        do {
            playerNum = Number.getInstance().playerNum(br);
            gameResult = Feature.getInstance().checkNum(hashMap, playerNum);
        }while(gameResult != 3);

    }
}
