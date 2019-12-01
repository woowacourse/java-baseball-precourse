package Baseball;

import java.util.Random;

public class RandomNumber {
    private boolean[] usedNumber;
    private int randomNumber;

    private void resetRandomNumber(){
        this.randomNumber = 0;
        this.usedNumber = new boolean[10];
    }

    public void createRandomNumber(){
        Random random = new Random();
        int digits = 0;

        resetRandomNumber();
        while(digits < 3){
            int x = random.nextInt(9) + 1;
            if(usedNumber[x]){
                continue;
            }
            randomNumber += x * Math.pow(10,digits);
            usedNumber[x] = true;
            digits++;
        }
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    public boolean[] getUsedNumber(){
        return usedNumber;
    }

}
