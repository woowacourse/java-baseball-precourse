package kr.latera.baseball;

import kr.latera.baseball.interfaces.IJudge;
import kr.latera.baseball.interfaces.IUserInterface;

public class PlayerImpl extends AbstractPlayer {

  public PlayerImpl(IJudge judge, IUserInterface ui) {
    super(judge, ui);
    init();
  }

  @Override
  public void doLoop() {
    int[] input = ui.promptInput();
    boolean validity = judge.isValidInput(input);

    while (!validity) {
      ui.displayForInvalidInput();
      input = ui.promptInput();
      validity = judge.isValidInput(input);
    }

    int strike = judge.checkStrike(input);
    int ball = judge.checkBall(input);

    ui.displayResult(strike, ball);
    if (strike == input.length) {
      handleUserSelection(ui.promptRestart());
    }
  }

  private void handleUserSelection(IUserInterface.UserSelection sel) {
    while (sel == IUserInterface.UserSelection.INVALID) {
      ui.displayForInvalidInput();
      sel = ui.promptRestart();
    }

    switch (sel) {
      case RESTART:
        init();
        break;
      case EXIT:
        isEnd = true;
        break;
    }
  }
}
