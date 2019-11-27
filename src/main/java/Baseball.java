import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private final int BASEBALL_LENGTH = 3;

    public int[] getBaseball() {
        int[] baseballArray = new int[BASEBALL_LENGTH];
        List<Integer> baseballList = new ArrayList<>();

        return createBaseball(baseballArray, baseballList);
    }

    private int[] createBaseball(int[] baseballArray, List<Integer> baseballList) {

        while(baseballList.size() != 3) {

            double createBaseball = Math.random();
            int baseball = (int)(createBaseball*9)+1;
            if(!baseballList.contains(baseball)) { baseballList.add(baseball); }
        }

        return inputBaseballListToArray(baseballArray, baseballList);
    }

    private int[] inputBaseballListToArray(int[] baseballArray, List<Integer> baseballList) {

        for(int i=0; i<baseballList.size(); i++) {

            baseballArray[i] = baseballList.get(i);
        }

        return baseballArray;
    }
}
