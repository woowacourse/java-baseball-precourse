package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
    private Set<Integer> numberHashSet;
    private Target target;
    private Player player;

    public Referee(Target target, Player player){
        this.target = target;
        this.player = player;
        numberHashSet = new HashSet<>(Arrays.stream(target.getTargetNumber().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public ScoreBoard judge(){
        int strikeCount = 0;
        int ballCount = 0;
        for(int i = 0; i < player.getNumber().length(); i++){
            char number = player.getNumber().charAt(i);
            if(target.getTargetNumber().charAt(i) == number){
                strikeCount++;
            }else if(numberHashSet.contains(Character.getNumericValue(number))){
                ballCount++;
            }
        }
        return new ScoreBoard(strikeCount, ballCount, player.getNumber().length());
    }
}
