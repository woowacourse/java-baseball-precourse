package baseball;

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
    }
    
}
