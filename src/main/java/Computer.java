
public class Computer {
    private int computerNumber[];
    private boolean overlapNumber[];
    Computer() {
        getRandomNumber();
    }

    private void getRandomNumber() {
        computerNumber = new int[3];
        overlapNumber = new boolean[10];
        computerNumber[0] = randomNumber();
        computerNumber[1] = randomNumber();
        computerNumber[2] = randomNumber();
    }

    private int randomNumber() {
        boolean check = false;
        int num = 0;
        while(!check){
            num = (int) (Math.random()*10);
            check = checkOverlapNum(num);
        }
        return num;
    }

    private boolean checkOverlapNum(int num) {
        if(num==0) return false;
        if(!overlapNumber[num]){
            overlapNumber[num] = true;
            return true;
        }
        return false;
    }

    public int[] getComputerNumber() {
        return computerNumber;
    }

}
