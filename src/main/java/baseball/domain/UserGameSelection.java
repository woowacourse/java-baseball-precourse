package baseball.domain;

import baseball.constants.GameConstants;

public class UserGameSelection {
	private GameConstants.GameOverInput userGameSelection;

	public UserGameSelection(GameConstants.GameOverInput userGameSelection) {
		this.userGameSelection = userGameSelection;
	}

	public void setUserGameSelection(GameConstants.GameOverInput userGameSelection) {
		this.userGameSelection = userGameSelection;
	}

	public GameConstants.GameOverInput getUserGameSelection() {
		return userGameSelection;
	}
}
