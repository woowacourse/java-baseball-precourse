import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baseball {
    public static List<Integer> getNum3(){
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(arr);
        List<Integer> subList = arr.subList(0, 3);
        Collections.sort(subList);
        return subList;
    }

    public static void main(String args[]){
        List<Integer> baseballNum = getNum3();
        return;
    }
}
