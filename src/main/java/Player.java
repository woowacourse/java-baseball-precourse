import java.util.Scanner;

class Player {
    private boolean wantToContinue;
    private Scanner input;

    Player() {
        this.wantToContinue = true;
        this.input = new Scanner(System.in);
    }

    public int getPlayerInputNumber() {
        return input.nextInt();
    }

    public boolean toBeContinued() {
        return this.wantToContinue;
    }

    public void playerQuitGame() {
        this.wantToContinue = false;
    }
}
