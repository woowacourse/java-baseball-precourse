/*
 * @이 코드는 누구나 열람할 수 있으며 사용하셔도 됩니다.
 */
import java.util.HashSet;


import java.util.Iterator;
import java.util.Scanner;
/*
 * @우아한 테크코스 과제 1. 숫자야구게임 만들기 최유성
 * Ver. 1.0.0
 * 2019년03월25일
 * github URL : https://github.com/YuSeongChoi/java-baseball/tree/yuseong
 *
 */

public class Baseball {
    /** num은 HashSet으로서 중복되지 않은 숫자가 입력되도록 사용함!!  */
    static HashSet<Integer>num = new HashSet<Integer>();
    /* inputNum과 comNum은 User와 Com의 숫자를 배열로 받아주기 위해 사용함!!*/
    static int[] inputNum = new int[3];
    static int[] comNum = new int[3];

    public static void main(String[] args) {
        newStart();			//숫자야구 프로그램을 동작해주는 메소드 집합
    }

    static void createNumber() { 	//COM에게 무작위의 숫자 3개를 만들어주는 메소드

        removeNumber();		// 새로 게임을 시작할 경우 기존의 HashSet을 비워준다.

        while(true) {
            int random = (int)(Math.random() * 9 + 1);
            num.add(random);
            if(num.size() == 3)
                break;
        }
    }

    static void removeNumber() {		//Hash Set을 비워주는 메소드
        Iterator<Integer> iterator = num.iterator();

        while(iterator.hasNext()) {
            Integer element = iterator.next();
            iterator.remove();
        }
    }

	/*
	static void printNumber() {			//COM의 숫자 3개를 알려주는 메소드
		Iterator<Integer> iterator = num.iterator();
		while(iterator.hasNext()) {
			Integer element = iterator.next();
			System.out.print(element);
		}
	}
	*/

    static void inputNumber() {			//User로부터 숫자를 입력받는 메소드
        Scanner scan = new Scanner(System.in);
        String tmp = "";

        System.out.print("숫자를 입력해주세요(3자리의 수) : ");
        tmp = scan.next();
        int num = Integer.parseInt(tmp);
        inputNum = resave(num);
    }

    //@Overloading
    static int[] resave(int num) {		//입력받은 숫자를 배열에 재저장하는 메소드
        int[] arr = new int[3];
        int check = num;

        arr[0] = num / 100;
        check = num % 100;
        arr[1] = check / 10;
        check = num % 10;
        arr[2] = check / 1;

        return arr;
    }

    //@Overloading
    static int[] resave(HashSet num) {		//COM의 숫자를 배열에 재저장하는 메소드
        int[] comNum = new int[3];

        Iterator<Integer> iterator = num.iterator();
        for(int i=0; i<3; i++) {
            comNum[i] = iterator.next();
        }

        return comNum;
    }

    static void check(int[] input, int[] com) {		//COM의 숫자와 User의 숫자를 비교,대조해주는 메소드
        int strike = 0;
        int ball = 0;
        int number = 0;

        for(int i=0; i<3; i++) {		//Strike, ball일 때의 경우를 계산해준다.
            if(input[i] == com[i])		// If문의 단순한 중첩.. 더 효율적으로 계산할 수는 없을까???
                strike+=1;
        }
        if((input[0]==com[1]) || (input[0] == com[2])) {
            ball+=1;
        }
        if((input[1]==com[0]) || (input[1] == com[2])) {
            ball+=1;
        }
        if((input[2]==com[0]) || (input[2] == com[1])) {
            ball+=1;
        }


        if(strike == 3) {				//strike와 ball의 경우에 따른 다른 결과 도출!!
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");		//단순 if문 말고 더 나은 개선방법이 없을까???
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
            System.out.println("낫싱");
            repeat();
        }
    }

    static void repeat() {		//한번의 User입력이 끝난 후 새로운 숫자를 입력받기위한 메소드
        inputNumber();
        comNum = resave(num);
        check(inputNum,comNum);
    }

    static void newStart() {		//Game이 끝난 후 다시 시작할 때 사용하는 메소드
        createNumber();
        inputNumber();
        comNum = resave(num);
        check(inputNum,comNum);
    }

}
