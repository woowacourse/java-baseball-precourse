package input;

import java.util.Arrays;
import java.util.Scanner;

public class InputCheck {

    private static final int COMMAND_LENGTH = 1;
    private static final int PREDICT_LENGTH = 3;

    private static boolean[] visited;
    private boolean terminal;

    public InputCheck() {
        visited = new boolean['9' + 1];
        this.terminal = false;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public String check(String line) {
        
        // 오류 처리
        if(!checkOnlyNumbers(line)) {
            throw new IllegalArgumentException();
        }

        initVisited();

        boolean ok = true;

        if(terminal) {
            ok = checkCommand(line);
        } else if(!terminal) {
            ok = checkPredict(line);
        }

        // 오류 처리
        if(!ok) {
            throw new IllegalArgumentException();
        }

        return line;
    }

    private boolean checkCommand(String line) {
        return checkCommandLength(line) && (line.charAt(0) == '1' || line.charAt(0) == '2');
    }

    private boolean checkCommandLength(String line) {
        return line.length() == COMMAND_LENGTH;
    }

    private boolean checkPredict(String line) {
        return line.length() == PREDICT_LENGTH && !checkOverlap(line);
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
        return c >= '1' && c <= '9';
    }
}
