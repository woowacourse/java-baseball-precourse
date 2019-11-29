/**
* Main class
*
* v1.0
*
* 2019-11-29
*
* MIT Licence
*/
public class Main {

    /* 코드 진입점 */
    public static void main(String[] args) {
        while (true) {

            /*무한히 진행한다*/
            Baseball b_ball = new Baseball();
            if(!b_ball.doBaseball()){

                /*만약 플레이어가 종료하겠다면*/
                break;
            }
        }
    }
}
