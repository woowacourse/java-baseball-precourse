package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class User {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int[] sendMessage() throws IOException {
        int num[] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        return num;
    }

    public void readMessage(String message){
        System.out.print(message);
    }
}