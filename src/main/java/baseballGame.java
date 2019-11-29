/*
 * baseballGame.java
 * v1.01
 * 2019.11.29
 *
 */

public class baseballGame {

    public static void main(String[] args) {
        gameMc game = new gameMc();
        do{
            game.setUserNum();
            game.compare();
            game.scoring();
        } while(game.checkStatus() != 2);

    }
}