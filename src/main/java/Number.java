import java.util.HashMap;

public class Number {

    private HashMap<Integer,Integer> hashMap;

    // 클래스 안에 클래스 holder를 두는 Singleton
    private Number(){ hashMap = new HashMap<>(); }
    private static class ComputerHolder{ public static final Number INSTANCE = new Number();}
    public static Number getInstance(){ return ComputerHolder.INSTANCE; }

    public HashMap comNum(){
        for(int i = 0 ; i < 3 ; i ++){
            int num = (int) (Math.random() * 9 ) + 1;
            hashMap.put(i,num);
            if(i == 0) continue;
            if(hashMap.get(i-1) == num){
                i -= 1;
            }
        }
        return hashMap;
    }


}
