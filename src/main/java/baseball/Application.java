package baseball;

import model.GameDataInterface;
import model.classes.CountingStatus;
import model.classes.GameData;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		//GameDataInterface m = new GameData();
		//m.inputUserAnswer();
		//m.setGameMode();
		CountingStatus countingStatus = new CountingStatus();
		System.out.println(countingStatus.toString());
	}
}