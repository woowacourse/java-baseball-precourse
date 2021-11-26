package baseball;

import java.net.InterfaceAddress;
import java.util.InputMismatchException;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Number.*;

public class Game {
	private static final int RESTART_CODE = 1;
	private static final int EXIT_CODE = 2;

	//사용자에게 입력받기
	public static void play() {
		Number random = new Number();
		Number player = new Number();
		String temp;

		random.setNumber(random.createRandomNumbers());

		while (true) {
			System.out.println("숫자를 입력해 주세요 : ");

			temp = Console.readLine();
			inputCheck(Integer.parseInt(temp)); // 예외처리

			player.setNumber(splitNumber(Integer.parseInt(temp)));

			GameHelper gameHelper = new GameHelper();
			if (gameHelper.judgement(random.getNumber(), player.getNumber()))
				break;
		}
	}

	public static int isContinue() {
		System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");

		String input = Console.readLine();

		switch (input) {
			case "1":
				return RESTART_CODE;
			case "2":
				return EXIT_CODE;
			default:
				throw new IllegalArgumentException("잘못된 값 입력");
		}
	}
}
