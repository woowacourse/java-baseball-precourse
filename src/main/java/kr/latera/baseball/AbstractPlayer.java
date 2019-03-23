package kr.latera.baseball;

import kr.latera.baseball.interfaces.IJudge;
import kr.latera.baseball.interfaces.IUserInterface;

public abstract class AbstractPlayer {

  protected IJudge judge;
  protected IUserInterface ui;
  protected boolean isEnd;

  public AbstractPlayer(IJudge judge, IUserInterface ui) {
    this.isEnd = false;
    this.judge = judge;
    this.ui = ui;
  }

  /**
   * 정답 숫자를 새로 생성함
   */
  public void init() {
    judge.init();
  }

  public boolean isEnd() {
    return isEnd;
  }

  /**
   * 입력 받고, 확인하고, 결과를 출력하는 루프를 1회 수행함
   */
  public abstract void doLoop();
}
