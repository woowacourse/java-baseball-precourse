package Baseball;

public class PlayBaseball {
    private static RandomNumber random;
    private static InputNumber input;
    private static int randomNumber;
    private static int inputNumber;
    private final static int end_Game = 2;
    private final static int do_Game = 1;

    public PlayBaseball(){}

    public void setRandomNumber(){
        random = new RandomNumber();
        random.createRandomNumber();
        this.randomNumber = random.getRandomNumber();
    }

    public void setInputNumber(){
        input = new InputNumber();
        input.input();
        inputNumber = input.getInputNumber();
    }


}
