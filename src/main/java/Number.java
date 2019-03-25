import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Number {

    private HashMap<Integer,Integer> hashMap;

    // 클래스 안에 클래스 holder를 두는 Singleton
    private Number(){ hashMap = new HashMap<>(); }
    private static class NumberHolder{ public static final Number INSTANCE = new Number();}
    public static Number getInstance(){ return NumberHolder.INSTANCE; }

    //컴퓨터 3자리 난수 생성 함수
    public HashMap comNum(){

        if(!hashMap.isEmpty()){
            hashMap.clear();
        }

        for(int i = 0 ; i < 3 ; i ++){
            int num = (int) (Math.random() * 9) + 1;
            if(isOverLap(hashMap,num)){
                i -= 1;
                continue;
            }
            hashMap.put(i,num);
        }
        return hashMap;
    }

    //컴퓨터 3자리난수 중복처리 함수
    private boolean isOverLap(HashMap hashMap, int num){
        for(Object data : hashMap.values()){
            if((int)data == num){
                return true;
            }
        }
        return false;
    }

    // player 세자리 입력 함수
    public String[] playerNum(BufferedReader br) throws IOException {
        return br.readLine().split("");
    }

}
