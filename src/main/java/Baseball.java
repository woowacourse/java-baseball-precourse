import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private final int BASEBALL_LENGTH = 3;

    public List<Integer> getBaseball() {
        int[] baseballArray = new int[BASEBALL_LENGTH];
        List<Integer> baseballList = new ArrayList<>();

        return createBaseball(baseballArray, baseballList);
    }

    private List<Integer> createBaseball(int[] baseballArray, List<Integer> baseballList) {

        while(baseballList.size() != 3) {

            double createBaseball = Math.random();
            int baseball = (int)(createBaseball*9)+1;
            if(!baseballList.contains(baseball)) { baseballList.add(baseball); }
        }

        return baseballList;
    }
}
