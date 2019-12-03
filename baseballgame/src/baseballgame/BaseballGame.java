package baseballgame;
import java.util.Random;
import java.util.Scanner;
public class BaseballGame {
	Scanner sc = new Scanner(System.in);
	private static int number1;
	private static int number2;
	private static int number3;
	private static int ball;
	private static int strike;
	private static boolean clear = false;
	
	public void setNumber1(int number1) {
		BaseballGame.number1 = number1;
	}
	public void setNumber2(int number2) {
		BaseballGame.number2 = number2;
	}
	public void setNumber3(int number3) {
		BaseballGame.number3 = number3;
	}
	public static void setBall(int ball) {
		BaseballGame.ball = ball;
	}
	public static void setStrike(int strike) {
		BaseballGame.strike = strike;
	}
	public void setClear() {
		if(getStrike()==3) {
			BaseballGame.clear = true;
		}else {
			BaseballGame.clear = false;
		}
	}
	
	public static int getNumber1() {
		return number1;
	}
	public static int getNumber2() {
		return number2;
	}
	public static int getNumber3() {
		return number3;
	}
	public static int getBall() {
		return ball;
	}
	public static int getStrike() {
		return strike;
	}
	public static boolean isClear() {
		return clear;
	}
	
	public void setNum() {
		Random random = new Random();
		int tmpNumber1;
		int tmpNumber2;
		int tmpNumber3;
		
		tmpNumber1 = random.nextInt(10);
		tmpNumber2 = random.nextInt(10);
		tmpNumber3 = random.nextInt(10);
		
		while(tmpNumber1==tmpNumber2) {
			tmpNumber2 = random.nextInt(10);
		}
		while((tmpNumber1==tmpNumber3)||(tmpNumber2==tmpNumber3)) {
			tmpNumber3 = random.nextInt(10);
		}
		setNumber1(tmpNumber1);
		setNumber2(tmpNumber2);
		setNumber3(tmpNumber3);
	}
	
	public static void countBall(int num1, int num2, int num3) {
		int count = 0;
		if((num1 != getNumber1())&&((num1 == getNumber2())||(num1 == getNumber3()))) {
			count++;
		}
		if((num2 != getNumber2())&&((num2 == getNumber1())||(num2 == getNumber3()))) {
			count++;
		}
		if((num3 != getNumber3())&&((num3 == getNumber1())||(num3 == getNumber2()))) {
			count++;
		}
		setBall(count);
	}
	public static void countStrike(int num1, int num2, int num3) {
		int count = 0;
		if(num1==getNumber1()) {
			count++;
		}
		if(num2==getNumber2()) {
			count++;
		}
		if(num3==getNumber3()) {
			count++;
		}
		setStrike(count);
	}

	
	public void printResult() {
		if((getStrike()==0)&&(getBall()==0)) {
			System.out.println("아웃!");
		}else if(getStrike()==0) {
			System.out.println(getBall()+" 볼");
		}else if(getBall()==0) {
			System.out.println(getStrike()+" 스트라이크");
		}else {
			System.out.println(getStrike()+" 스트라이크"+getBall()+" 볼");
		}
	}
	public void checkAnswer(int num1, int num2, int num3) {
		countBall(num1, num2, num3);
		countStrike(num1, num2, num3);
		printResult();
	}
	public void run() {
		int input;
		int tmpNum1;
		int tmpNum2;
		int tmpNum3;
		initializing();
		while(!isClear()) {
			System.out.print("숫자를 입력해주세요 : ");
			input = sc.nextInt();
			tmpNum3 = input%10;
			input = input/10;
			tmpNum2 = input%10;
			input = input/10;
			tmpNum1 = input;
			checkAnswer(tmpNum1, tmpNum2, tmpNum3);
			setClear();
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
	public void initializing() {
		setNum();
		setBall(0);
		setStrike(0);
		setClear();
	}
}
