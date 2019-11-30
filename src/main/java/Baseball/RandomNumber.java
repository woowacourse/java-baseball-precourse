package Baseball;

import java.util.Random;

public class RandomNumber {
    private static boolean[] usedNumber;
    private static int randomNumber;

    public RandomNumber(){}

    private void resetRandomNumber(){
        this.randomNumber = 0;
        this.usedNumber = new boolean[10];
    }

    public void createRandomNumber(){
        Random random = new Random();
        int iter = 0;

        resetRandomNumber();
        while(iter < 3){
            int x = random.nextInt(9) + 1;
            if(usedNumber[x]){
                continue;
            }
            randomNumber += x * Math.pow(10,iter);
            usedNumber[x] = true;
            iter++;
        }
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    public boolean[] getUsedNumber(){
        return usedNumber;
    }

}
