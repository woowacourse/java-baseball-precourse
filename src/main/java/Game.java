public class Game {
    Computer computer;
    Player player;
    private void init(){
        computer = new Computer();
        player = new Player();
    }

    public void run(){
        init();
    }
}
