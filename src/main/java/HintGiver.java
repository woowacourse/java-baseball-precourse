public class HintGiver {
    public static boolean giveHint(int tcnt, int scnt){
        if(scnt==3){
            System.out.println("3 스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        if(tcnt == 0){
            System.out.println("낫싱");
        } else if(tcnt == scnt){
            System.out.println(scnt+" 스트라이크");
        } else if(scnt==0){
            System.out.println(tcnt+" 볼");
        } else{
            System.out.println(scnt+" 스트라이크 "+(tcnt-scnt)+" 볼");
        }
        return false;
    }
}
