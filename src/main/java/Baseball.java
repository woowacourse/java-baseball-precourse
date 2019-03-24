import java.util.HashSet;

import java.util.Iterator;
import java.util.Scanner;

public class Baseball {
    static HashSet<Integer>num = new HashSet<Integer>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] inputNum = new int[3];
        int[] comNum = new int[3];

        createNumber();
        inputNum = inputNumber();
        comNum = resave(num);



//		printNumber();
    }

    static void createNumber() {
        while(true) {
            int random = (int)(Math.random() * 9 + 1);
            num.add(random);
            if(num.size() == 3)
                break;
        }
    }

    static void printNumber() {
        Iterator<Integer> iterator = num.iterator();
        while(iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element);
        }
    }

    static int[] inputNumber() {
        int[] inputNum = new int[3];
        Scanner scan = new Scanner(System.in);
        String tmp = "";

        System.out.println("숫자를 입력해주세요(3자리의 수) : ");
        tmp = scan.next();
        int num = Integer.parseInt(tmp);
        inputNum = resave(num);

        return inputNum;
    }

    static int[] resave(int num) {
        int[] arr = new int[3];
        int check = num;

        arr[0] = num / 100;
        check = num % 100;
        arr[1] = check / 10;
        check = num % 10;
        arr[2] = check / 1;

        return arr;
    }

    static int[] resave(HashSet num) {
        int[] comNum = new int[3];

        Iterator<Integer> iterator = num.iterator();
        for(int i=0; i<3; i++) {
            comNum[i] = iterator.next();
        }

        return comNum;
    }
}
