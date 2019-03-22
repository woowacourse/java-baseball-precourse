package kr.latera.baseball.interfaces;

public interface IJudge {

  void init();
  boolean isValidInput(int[] input);
  int checkStrike(int[] input) throws IllegalArgumentException;
  int checkBall(int[] input) throws IllegalArgumentException;
}
