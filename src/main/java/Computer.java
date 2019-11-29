import java.util.ArrayList;
import java.util.Random;

public class Computer {
    private ArrayList<Integer> computerNumberSet;

    public Computer() {
        computerNumberSet = new ArrayList<Integer>();

        setRandomNumber();
    }

    private void setRandomNumber() {
        ArrayList<Boolean> checkList = new ArrayList<Boolean>();

        for (int i = 0; i < 10; i++) {
            checkList.add(false);
        }
        addNumber(checkList);
    }

    private void addNumber(ArrayList<Boolean> list) {
        Random random = new Random();
        int ranNum;

        for (int i = 0; i < 3; ) {
            ranNum = random.nextInt(9) + 1;
            while (list.get(ranNum).equals(false)) {
                list.set(ranNum, true);
                computerNumberSet.add(ranNum);
                i = i + 1;
            }
        }
    }

    public ArrayList<Integer> getNumberSet() {
        return computerNumberSet;
    }

    public void restartGame() {
        computerNumberSet.clear();
        setRandomNumber();
    }
}