package baseball;


import java.util.InputMismatchException;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import static baseball.Number.*;


public class Game {
	private static final int RESTART_CODE = 1;
	private static final int EXIT_CODE = 2;
	private static final int BASEBALL_NUM = 3;

	//사용자에게 입력받기
	public static void play(Scanner input) {
		Number random = new Number();
		Number player = new Number();
		String temp;

		random.setNumber(random.createRandomNumbers());

		while(true) {
			System.out.println("숫자를 입력해 주세요 : ");
			try {
				temp = Console.readLine();
			}catch (InputMismatchException e){
				throw new IllegalArgumentException("올바른 입력이 아닙니다!");
			}

			inputCheck(Integer.parseInt(temp));


		}
	}
}
