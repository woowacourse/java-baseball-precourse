import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PlayGame {

    private HashMap<Integer,Integer> hashMap;
    public void startGame() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String playerNum[];

        while(true){
            hashMap = Number.getInstance().comNum();

           /* System.out.print("컴퓨터 숫자 : ");
            for(Object data : hashMap.values()){
                System.out.print(data);
            }*/

            playerNum = Number.getInstance().playerNum(br);
            for(String data : playerNum){
                System.out.print(data);
            }

        }

    }
}
