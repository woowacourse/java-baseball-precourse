package kr.latera.baseball;

import kr.latera.baseball.interfaces.IUserInterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class StreamUserInterface implements IUserInterface {

  private InputStream is;
  private OutputStream os;
  private Scanner sc;

  public StreamUserInterface(InputStream input, OutputStream output) {
    is = input;
    os = output;
    sc = new Scanner(is);
  }

  @Override
  public int[] promptInput() {
    try {
      os.write("숫자를 입력해주세요 : ".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return separateNum(sc.next());
  }

  @Override
  public UserSelection promptRestart() {
    try {
      os.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n".getBytes());
      int selection = sc.nextInt();

      switch(selection) {
        case 1:
          return UserSelection.RESTART;
        case 2:
          return UserSelection.EXIT;
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    return UserSelection.INVALID;
  }

  @Override
  public void displayResult(int strike, int ball) {
    if (strike == 3) {
      print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    } else if (ball == 0 && strike == 0) {
      print("낫싱\n");
    } else {
      if (strike > 0) {
        print(strike + "스트라이크");
      }
      if (strike > 0 && ball > 0) {
        print(" ");
      }
      if (ball > 0) {
        print(ball + "볼");
      }
      if (strike > 0 || ball > 0) {
        print("\n");
      }
    }
  }

  private int[] separateNum(String n) {
    int length = n.length();
    int[] arr = new int[length];

    for (int i = 0; i < length; i++) {
      arr[i] = Character.getNumericValue(n.charAt(i));
    }

    return arr;
  }

  private void print(String str) {
    try {
      os.write(str.getBytes());
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
