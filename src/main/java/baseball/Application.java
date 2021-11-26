package baseball;

import java.util.ArrayList;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static final int RESTART_CODE = 1;

	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		int playingStatus;

		do {
			Game.play();
			playingStatus = Game.isContinue();
		} while (playingStatus == RESTART_CODE);
	}
}
