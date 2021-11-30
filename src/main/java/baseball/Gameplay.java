package baseball;

import java.util.ArrayList;

public class Gameplay {

    Player player;
    Computer computer;

    //player와 computer 생성하는 함수
    public void GameSetting(){
        player = new Player();
        computer = new Computer();
    }

    //게임 플레이하는 함수
    public void Play() {
        GameSetting();

        computer.RandomNum(); //랜덤 숫자 생성

        while(true) {
            computer.PrintNumMSG();
            ArrayList<Integer> playerNum = player.InputNum();
            if(computer.BallStrikeNum(playerNum))
                break;
        }

        computer.PrintRestartMSG();

        if(player.InputRestart() == 1){
            Play();
        }

    }
}
