package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;

import baseball.vo.Point;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    public final String INPUT_MESSAGE = "숫자를 입력해 주세요: ";
    public final int INPUT_SIZE_LIMIT = 3;
    public final int STRIKE = 3;
    private String input;

    public void validate(String input){
        HashSet<Character> storeNumber = new HashSet<>();

        if(input.length() != INPUT_SIZE_LIMIT){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < input.length(); i++) {
            if (storeNumber.contains(input.charAt(i))){
                throw new IllegalArgumentException();
            }
            storeNumber.add(input.charAt(i));

            if (!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException();
            }

            if (input.charAt(i) == '0'){
                throw new IllegalArgumentException();
            }
        }
    }

    public void start(ArrayList<String> randomNumber){
        System.out.print(INPUT_MESSAGE);
        input = Console.readLine();

        validate(input);
        Point point = compare(randomNumber, input);
        OutputView outputView = new OutputView(point.getStrike(), point.getBall(), randomNumber);
        System.out.println(outputView.display());

        if(point.getStrike() != STRIKE){
            start(randomNumber);
        }
    }

    public Point compare(ArrayList<String> randomNumber, String input){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < input.length(); i++) {
            if (randomNumber.get(i).equals(String.valueOf(input.charAt(i)))){
                strikeCount ++;
            } else if(randomNumber.contains(String.valueOf(input.charAt(i)))){
                ballCount ++;
            }
        }
        return new Point(strikeCount, ballCount);
    }
}