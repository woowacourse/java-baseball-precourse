package numberBaseball.player;

public interface Player {
    public void setThreeNumber();
    public int[] guessThreeNumber();
    public void answerHintOf(int[] guessed);
    public boolean checkCorrect(int[] guessed);
}