package baseball;

class Baseball {
    public static void main(String[] args) {
        new GameLoop();
    }
}

class GameLoop {
    int[] numbers;
    int state; // 상태 변수, 0 : 종료, 1 : 초기화, 2 : 게임 한 판, 3 : 종료 혹은 재시작 선택

    GameLoop(){
        state = 1;
        while (state > 0) {
            switch (state) {
                case 1 :
                    init();
                    break;
                case 2 :
                    play();
                    break;
                case 3 :
                    choice();
                    break;
                default :
                    state = 0;
                    break;
            }
        }
    }

    private void init() {
        for(int i = 0; i < 3; i++) {
            numbers[i] = (int)(Math.random() * 9.0) + 1;
        }
        state = 2;
    }

    private void play() {

    }

    private void choice() {

    }
}