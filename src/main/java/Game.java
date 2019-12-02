public class Game {

  private IOController io = new IOController();
  private Baseball baseBall = new Baseball();


  public boolean start() {
    boolean gotAnswer = false;

    this.baseBall.generateAnswer();

    while (!gotAnswer) {
      gotAnswer = play();
    }

    boolean nextAction = this.io.selectNextAction();

    return nextAction;
  }

  private boolean play() {
    int inputNumber = this.io.getNumberOfUser();

    int[] score = this.baseBall.matchNumber(inputNumber);

    this.io.printResult(score);

    if (score[0] >= 3) {
      return true;
    }
    return false;

  }


}
