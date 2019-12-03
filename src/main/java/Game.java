public class Game {
    Computer computer;
    Player player;

    private void init(){
        computer = new Computer();
        player = new Player();
    }

    private void play(){
        computer.generateRandomNumber();
        player.getInput();
    }

    public void run(){
        init();
        play();
    }
}
