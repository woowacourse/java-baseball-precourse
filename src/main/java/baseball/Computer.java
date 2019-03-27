package baseball;

public class Computer {
    private int num[];

    private void makeRandomNumber(){
        num = new int[3];

        num[0] = (int)(Math.random()*9 + 1);
        num[1] = (int)(Math.random()*9 + 1);

        while (num[0] == num[1]){
            num[1] = (int)(Math.random()*9 + 1);
        }
        num[2] = (int)(Math.random()*9 + 1);

        while ((num[0] == num[2]) || (num[1] == num[2])){
            num[2] = (int)(Math.random()*9 + 1);
        }
    }

}
