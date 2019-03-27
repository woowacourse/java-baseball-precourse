package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class User {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private String[] inputMessage() throws IOException {
        return bufferedReader.readLine().split("");
    }

    public int[] sendMessage() throws IOException{
        return Arrays.stream(inputMessage()).mapToInt(Integer::parseInt).toArray();
    }

    public void readMessage(String message){
        System.out.print(message);
    }
}