package baseball;

import java.util.List;

public class User {

	GameReply gameReply = new GameReply();
	AfterGameReply afterGameReply = new AfterGameReply();

	public boolean askExit() {
		return afterGameReply.askAfterGameReply();
	}

	public List<Integer> askReply() {
		return gameReply.askReply();
	}

	public void replyValidation() {
		gameReply.validation();
	}
}
