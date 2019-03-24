import java.util.HashSet;

import java.util.Iterator;
import java.util.Scanner;

public class Baseball {
    static HashSet<Integer>num = new HashSet<Integer>();
    static int[] inputNum = new int[3];
    static int[] comNum = new int[3];

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        createNumber();
        inputNumber();
        comNum = resave(num);
        check(inputNum,comNum);
        repeat();

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

    static void inputNumber() {
//		int[] inputNum = new int[3];
        Scanner scan = new Scanner(System.in);
        String tmp = "";

        System.out.print("숫자를 입력해주세요(3자리의 수) : ");
        tmp = scan.next();
        int num = Integer.parseInt(tmp);
        inputNum = resave(num);

//		return inputNum;
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

    static void check(int[] input, int[] com) {
        int strike = 0;
        int ball = 0;
        for(int i=0; i<3; i++) {
            if(input[i] == com[i])
                strike++;
        }
        if((input[0]==com[1]) || input[0] == com[2])
            ball++;
        if(input[1]==com[2])
            ball++;

        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        else if((strike > 0) && (ball > 0)) {
            System.out.println(strike + "스트라이크" + ball + "볼");
        }
        else if(strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        else if(ball > 0) {
            System.out.println(ball + "볼");
        }
        else
        {
            System.out.println("0 스트라이크 0볼입니다.");
        }
    }

    static void repeat() {
        inputNumber();
        comNum = resave(num);
        check(inputNum,comNum);
    }

}
