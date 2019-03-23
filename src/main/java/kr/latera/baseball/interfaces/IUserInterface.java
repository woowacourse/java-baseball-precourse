package kr.latera.baseball.interfaces;

public interface IUserInterface {
  enum UserSelection { RESTART, EXIT, INVALID }

  int[] promptInput();
  UserSelection promptRestart();
  void displayResult(int strike, int ball);
  void displayForInvalidInput();

}
