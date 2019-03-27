package indi.moon.firstweek;

import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Stream;

public class User extends Config implements Userface  {

    @Override
    public int[] receiveNum() {
        System.out.println("정답을 시도하세요!");
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        int[] arraynum = makeNumArray(num);
        return arraynum;
    }
}
