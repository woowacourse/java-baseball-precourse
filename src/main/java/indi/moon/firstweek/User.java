package indi.moon.firstweek;

import java.util.Scanner;

public class User extends Config implements Userface  {
    @Override
    public int[] receiveNum() {
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        int[] arraynum = makeNumArray(num);
        return arraynum;
    }
}
