package input;

import java.util.Arrays;
import java.util.Scanner;

public class InputCheck {

    private static boolean[] visited;

    private final Scanner scanner;

    public InputCheck(Scanner scanner) {
        this.scanner = scanner;
        visited = new boolean['9' + 1];
    }

    public String getLine() {

        String line = scanner.nextLine();

        initVisited();

        // 오류 처리
        if(!checkOnlyNumbers(line) || checkOverlap(line)) {
            throw new IllegalArgumentException();
        }

        return line;
    }

    private void initVisited() {
        Arrays.fill(visited, false);
    }

    private boolean checkOverlap(String line) {

        for(char c : line.toCharArray()) {
            if(visited[c]) {
                return true;
            }
            visited[c] = true;
        }

        return false;

    }

    private boolean checkOnlyNumbers(String line) {

        for(char c : line.toCharArray()) {
            if(!checkNumber(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
