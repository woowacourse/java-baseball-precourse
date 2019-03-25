public class Counter {
    public static int countIncludedNum(String input, String target){
        int cnt = 0;
        for (char elem : input.toCharArray())
            for (char comp : target.toCharArray())
                if(elem == comp) cnt++;
        return cnt;
    }

    public static int countMatchedNum(String input, String target){
        int cnt =0;
        for (int i=0; i<3; i++)
            if(input.charAt(i)==target.charAt(i)) cnt++;
        return cnt;
    }
}
