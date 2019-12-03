import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * The type Batter.
 */
class Batter {
    private LinkedHashSet<Integer> batting;
    private final static int BATTING_COUNT = 3;

    /**
     * Instantiates a new Batter.
     */
    public Batter() {
        batting = new LinkedHashSet<>();
        while (batting.size() != 3) {
            Integer tmp = (int) (Math.random() * 9 + 1);
            batting.add(tmp);
        }
    }

    /**
     * Print batting.
     */
    public void printBatting() {
        for (Integer tmp : batting) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    /**
     * Game boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean game(Pitcher user){
        int[] pitch = user.getPitching();
        Object[] bat = batting.toArray();
        int strike = 0, ball = 0, nothing = 0;

        if(pitch[0]==0){
            System.out.println("Error로 인해 다시 게임을 시작합니다.");
            return false;
        }
        for(int i=0;i<BATTING_COUNT;i++){
            if(batting.contains(pitch[i]) && (int)bat[i] == pitch[i]) {
                strike++;
                nothing++;
            }
            else if(batting.contains(pitch[i]) && (int)bat[i] != pitch[i]){
                ball++;
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
