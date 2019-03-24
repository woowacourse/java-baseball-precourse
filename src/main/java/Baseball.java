import java.util.HashSet;

import java.util.Iterator;
import java.util.Scanner;

public class Baseball {
    static HashSet<Integer>num = new HashSet<Integer>();
    static int[] inputNum = new int[3];
    static int[] comNum = new int[3];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        newStart();
        printNumber();    // 컴퓨터의 숫자 값을 알려주는 메소드
    }

    static void createNumber() {

        removeNumber();

        while(true) {
            int random = (int)(Math.random() * 9 + 1);
            num.add(random);
            if(num.size() == 3)
                break;
        }
    }

    static void removeNumber() {
        Iterator<Integer> iterator = num.iterator();

        while(iterator.hasNext()) {
            Integer element = iterator.next();
            iterator.remove();
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
        int number = 0;


        for(int i=0; i<3; i++) {
            if(input[i] == com[i])
                strike+=1;
        }
        if((input[0]==com[1]) || (input[0] == com[2])) {
            System.out.println("ball이 증가하였습니다.");
            ball+=1;
        }
        if((input[1]==com[0]) || (input[1] == com[2])) {
            System.out.println("ball이 증가하였습니다.");
            ball+=1;
        }
        if((input[2]==com[0]) || (input[2] == com[1])) {
            System.out.println("ball이 증가하였습니다.");
            ball+=1;
        }


        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scan = new Scanner(System.in);
            number = scan.nextInt();
            if(number == 1)
                newStart();
            else {
                System.out.println("프로램을 종료합니다.");
                System.exit(0);
            }

        }
        if((strike > 0) && (ball > 0)) {
            System.out.println(strike + "스트라이크" + ball + "볼");
            repeat();
        }
        if(strike > 0) {
            System.out.println(strike + "스트라이크");
            repeat();
        }
        if(ball > 0) {
            System.out.println(ball + "볼");
            repeat();
        }
        else
        {
            System.out.println("0 스트라이크 0볼입니다.");
            repeat();
        }
    }

    static void repeat() {
        inputNumber();
        comNum = resave(num);
        check(inputNum,comNum);
    }

    static void newStart() {
        createNumber();
        inputNumber();
        comNum = resave(num);
        check(inputNum,comNum);
    }

}
