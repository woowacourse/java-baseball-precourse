import java.util.*;

public class Baseball {
    public static List<Integer> getNum3(){
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(arr);
        List<Integer> subList = arr.subList(0, 3);
        Collections.sort(subList);
        return subList;
    }
    public static List<Integer> get3(){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int a = num/100;
        num%=100;
        List<Integer> thisList = new ArrayList<Integer>(Arrays.asList(a, num/10, num%10));
        return thisList;
    }

    public static void main(String args[]){
        List<Integer> baseballNum = getNum3();
        List<Integer> yourNum = get3();
        return;
    }
}
