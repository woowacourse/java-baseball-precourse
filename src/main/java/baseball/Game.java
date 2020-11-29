package baseball;

import java.util.Scanner;

public class Game {

    private int targetNumber;
    private boolean gotAnswer;

    public Game() {
        targetNumber = BaseballNumberGenerator.nextBaseballNumber();
        gotAnswer = false;
        System.out.println(targetNumber);
    }

    public void play(Scanner scanner) {
        while (!gotAnswer) {
            int inputNumber = InputChannel.askBaseballNumber(scanner);
            playOnePitch(inputNumber);
        }
    }

    private void playOnePitch(int inputNumber) {
        Pitch pitch = new Pitch(inputNumber, targetNumber);
        pitch.printHint();
        gotAnswer = pitch.isCorrect();
    }
}
