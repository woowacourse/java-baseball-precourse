import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PlayGame {

    private HashMap hashMap;
    private String playerNum[];
    private int gameResult;

    public void startGame() throws IOException {
        System.out.println("숫자 야구게임을 시작합니다.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do{
            hashMap = Number.getInstance().comNum();
            /*System.out.print("컴퓨터 숫자 : ");
            for (Object data : hashMap.values()) {
                System.out.print(data);
            }
            System.out.println("");*/

            do {
                playerNum = Number.getInstance().playerNum(br);
                gameResult = Feature.getInstance().checkNum(hashMap, playerNum);
            }while(gameResult != 3);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        }while(isExit(br));
    }

    public boolean isExit(BufferedReader br) throws IOException {
        String exitNum = br.readLine();
        if (exitNum.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}
