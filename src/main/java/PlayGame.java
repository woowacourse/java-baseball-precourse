import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PlayGame {

    private HashMap hashMap;
    private String playerNum[];

    public void startGame() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hashMap = Number.getInstance().comNum();

        System.out.print("컴퓨터 숫자 : ");
        for (Object data : hashMap.values()) {
            System.out.print(data);
        }
        System.out.println("");

        while (true) {
            playerNum = Number.getInstance().playerNum(br);
            if(Feature.getInstance().checkNum(hashMap, playerNum) == 3){
                break;
            }
        }

    }
}
