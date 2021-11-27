package baseball;

import java.util.List;

// 사용자의 응답처리를 담당하는 class
public class User {

	private final GameReply gameReply;
	private final AfterGameReply afterGameReply;

	public User() {
		this.gameReply = new GameReply();
		this.afterGameReply = new AfterGameReply();
	}

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
