public class Computer {

    private int[] computerNum;

    Computer() {
        computerNum = new int[3];
        saveComputerNums();
    }

    private void saveComputerNums() {
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
    }

    private int makeRandom() {
        return (int) (Math.random() * 9) + 1;
    }


    int[] getComputerNum() {
        return computerNum;
    }

}
