package baseball;

import domain.player.Player;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        player.startGame(scanner);
    }
}
