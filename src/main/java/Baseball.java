import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private final int BASEBALL_NUMBER_SIZE = 3;
    private final int MIN_BASEBALL_NUMBER = 1;
    private final int MAX_BASEBALL_NUMBER = 9;

    public List<Integer> getBaseball() {

        List<Integer> baseballList = new ArrayList<>();

        return createBaseball(baseballList);
    }

    private List<Integer> createBaseball(List<Integer> baseballList) {

        while(baseballList.size() != BASEBALL_NUMBER_SIZE) {

            double createBaseball = Math.random();
            int baseball = (int)(createBaseball*MAX_BASEBALL_NUMBER)+MIN_BASEBALL_NUMBER;

            if(!baseballList.contains(baseball)) { baseballList.add(baseball); }

        }

        return baseballList;
    }
}
