package com.github.callmewaggs.javabaseballprecourse.baseball;

import com.github.callmewaggs.javabaseballprecourse.baseball.player.ComputerPlayer;
import com.github.callmewaggs.javabaseballprecourse.baseball.player.UserPlayer;

import java.util.Scanner;

public class BaseballGame {
  private ComputerPlayer computerPlayer;
  private UserPlayer userPlayer;
  private Score score;
  private boolean play;

  public BaseballGame() {
    this.computerPlayer = new ComputerPlayer();
    this.userPlayer = new UserPlayer();
    this.score = new Score();
    this.play = true;
  }

  public void gameStart() {
    computerPlayer.prepareBall();

    while (play) {
      score.init();
      userPlayer.prepareBall();

      score.calculateWinning(computerPlayer.getBall(), userPlayer.getBall());
      score.printScore();

      if (score.isWin()) {
        askGameAgain();
      }
    }
  }

  private void askGameAgain() {
    int flag;
    while (true) {
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      Scanner scan = new Scanner(System.in);
      flag = scan.nextInt();

      if (!(flag == 1 || flag == 2)) System.out.println("다시 입력해 주세요.");
      else break;
    }

    if (flag == 1) {
      computerPlayer.prepareBall();
      score.init();
    } else {
      play = false;
    }
  }
}
