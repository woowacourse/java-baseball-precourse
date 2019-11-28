import java.util.ArrayList;

public class Main {
    private static final int NUMS_MAX_LENGTH = 3;
    private static final int MAX_PICK_NUM = 9;
    private static final int MIN_PICK_NUM = 1;

    private static ArrayList<Integer> pickComputerNums() {
        ArrayList<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < NUMS_MAX_LENGTH) {
            int num = (int)(Math.random()*MAX_PICK_NUM)+MIN_PICK_NUM;
            if (isDuplicatedNum(num, computerNums)) {
                continue;
            }
            computerNums.add(num);
        }
        return computerNums;
    }

    private static boolean isDuplicatedNum(int num, ArrayList<Integer> numsList) {
        for (int i=0; i<numsList.size(); i++) {
            if (num == numsList.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(pickComputerNums());
    }
}
