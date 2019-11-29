import java.util.HashSet;
import java.util.LinkedHashSet;

class Batter {
    private LinkedHashSet<Integer> batting;
    private final static int BATTING_COUNT = 3;
    public Batter() {
        batting = new LinkedHashSet<>();
        while (batting.size() != 3) {
            Integer tmp = (int) (Math.random() * 9 + 1);
            batting.add(tmp);
        }
    }
    public void printBatting() {
        for (Integer tmp : batting) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }
    public boolean game(Pitcher user){
        int[] pitch = user.getPitching();
        Object[] bat = batting.toArray();
        int strike = 0, ball = 0, nothing = 0;
        for(int i=0;i<BATTING_COUNT;i++){
            if(batting.contains(pitch[i])){
                if((int)bat[i] == pitch[i]){
                    strike++;
                }
                else{
                    ball++;
                }
                nothing++;
            }
        }
        if(nothing==0){
            System.out.println("낫씽");
            return false;
        }
        else{
            System.out.println(strike +" 스트라이크 "+ball+" 볼 ");
            if(strike == 3) return true;
            else    return false;

        }

    }

}
