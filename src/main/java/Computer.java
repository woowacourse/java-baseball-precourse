public class Computer {
    private int Number[];
    private static boolean check[];

    public void setRandomNumber() {
        Number = new int[3];
        check = new boolean[10];
        for(int i =0; i<3; i++) {
            Number[i] = randomNumber();
        }
    }

    private int randomNumber() {
        int checknum = 0;
        int RandomNumber =0;
        while(checknum==0) {
            RandomNumber = (int)(Math.random()*10);
            checknum = checkNumber(RandomNumber,check);
        }
        return RandomNumber;
    }

    private int checkNumber(int RandomNumber, boolean check[]) {
        if(RandomNumber == 0) return 0;
        if(check[RandomNumber] == false) {
            check[RandomNumber] = true;
            return 1;
        }
        return 0;
    }

    public int [] getRandomNumber() {

        return Number;
    }

}