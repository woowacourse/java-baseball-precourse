package kr.latera.baseball;

import kr.latera.baseball.interfaces.IUserInterface;

import java.util.ArrayList;
import java.util.List;

public class TestUserInterface implements IUserInterface {

  private List<int[]> inputs;
  private List<UserSelection> selections;
  private int currentInput = 0;
  private int currentSel = 0;
  private OnResultListener listener;

  public TestUserInterface(int[][] inputs, UserSelection[] selections) {
    this.inputs = new ArrayList<>();
    for (int[] input : inputs) {
      this.inputs.add(input);
    }

    for(UserSelection sel : selections) {
      this.selections.add(sel);
    }
  }

  @Override
  public int[] promptInput() {
    if (currentInput == inputs.size()) {
      throw new IllegalStateException("No more inputs to return");
    }
    return inputs.get(currentInput++);
  }

  @Override
  public UserSelection promptRestart() {
    if (currentSel == selections.size()) {
      throw new IllegalStateException("No more selections to return");
    }
    return selections.get(currentSel++);
  }

  @Override
  public void displayResult(int strike, int ball) {
    if (listener != null) {
      listener.onResult(strike, ball);
    }
  }

  @Override
  public void displayMessage(String msg) {

  }

  public void setOnResultListener(OnResultListener listener) {
    this.listener = listener;
  }

  public interface OnResultListener {
    void onResult(int strike, int ball);
  }
}
