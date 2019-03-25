import java.util.HashMap;

class Computer {

    private int[] computerNum;
    private HashMap<Integer,ComputerNum> computerNumMap;

    Computer() {
        computerNum = new int[3];
        computerNumMap = new HashMap<>();
        saveComputerNums();
    }

    void saveComputerNums() {
        boolean flag = true;
        int second, third;
        computerNum[0] = makeRandom();

        while (flag) {

            second = makeRandom();
            third = makeRandom();

            if (computerNum[0] != second && computerNum[0] != third && second != third) {
                computerNum[1] = second;
                computerNum[2] = third;
                flag = false;
            }
        }

        for (int i = 0; i < computerNum.length; i++) {
            computerNumMap.put(computerNum[i], new ComputerNum(i,computerNum[i]));
        }
    }

    HashMap<Integer, ComputerNum> getComputerNumMap() {
        return computerNumMap;
    }

    private int makeRandom() {
        return (int) (Math.random() * 9) + 1;
    }


    int[] getComputerNum() {
        return computerNum;
    }

}
