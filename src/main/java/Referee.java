import java.util.Arrays;

public class Referee {
    public int[] countStrikeBall(int[] userNum, int[] computerNum ) {
        int[] strikeBall = new int[] {0, 0};
        System.out.println(Arrays.toString(userNum));
        System.out.println(Arrays.toString(computerNum));
        for(int i = 0; i < userNum.length; i++) {
            if(compare(userNum[i], computerNum[i])) {
                strikeBall[0]++;
            }
        }
        return strikeBall;
    }

    public boolean compare(int a, int b) {
        if(a == b) return true;
        return false;
    }
}
