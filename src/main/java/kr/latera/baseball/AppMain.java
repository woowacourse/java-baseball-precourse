package kr.latera.baseball;

import kr.latera.baseball.interfaces.IJudge;
import kr.latera.baseball.interfaces.IUserInterface;

public class AppMain {

  public static void main(String[] args) {
    IJudge judge = new JudgeImpl(new RandomNumberGenerator());
    IUserInterface ui = new StreamUserInterface(System.in, System.out);
    PlayerImpl p = new PlayerImpl(judge, ui);

    while (!p.isEnd()) {
      p.doLoop();
    }
  }
}
