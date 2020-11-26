package baseball;

public class GameSetting {
    public RandomNumberGenerator randomNumberGenerator;
    public void makeRandomNumber(){
        randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.makeRandomNumber();
    }
}
