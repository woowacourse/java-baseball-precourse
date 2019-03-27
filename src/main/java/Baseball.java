import java.io.*;
import java.nio.Buffer;
import java.util.Random;

public class Baseball {

   String com;
   String usr;

   int[] st = new int[3];
   int[] ball = new int[3];
   boolean gameover = false;
   int quit = 1; //게임을 종료 시킬지 말지 결정하기 위한 변수
   int stsum;
   int ballsum; //각 시점에서 스트라이크가 총 몇개인지, 볼이 총 몇개인지 세기 위한 변수


   Random random = new Random();
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

   public void startGame() throws IOException{
      /* 숫자 입력을 받고 게임을 시작하는 함수 */

      while(true){
         if (quit==1){
            com = comRandom();
            boolean gameover = false;
            bw.write("숫자를 입력해주세요 : ");
            bw.flush();
            doGame();
         } else {
            return;
         }
      }
   }

   public void doGame() throws IOException {
      /* 게임 프로세스를 진행되는 함수 */
      while(true) {
         usr = br.readLine();
         countStrike();
         if (Is3strike()) {
            gameover = true;
            break;
         }
         else {
            countBall();
            countScore();
            printScore();
            clearScore();
         }
      }

      if(gameover==true) {
         if(quitOrNot()){
            quit=2;
         } else{
            quit=1;
         }
      }
   }



   public String comRandom(){
      /* 중복없이 세 자리 수를 생성하는 함수*/

      int first;
      int second;
      int third;
      while (true){
         first = random.nextInt(9) + 1;
         second = random.nextInt(9) + 1;
         third = random.nextInt(9) + 1;
         if(first != second && second != third && third != first){
            break;
         }
      }
      String s = String.valueOf(first) + String.valueOf(second) + String.valueOf(third);

      return s;
   }


   public void countStrike(){
      for (int i=0;i<com.length();++i){
         if (com.charAt(i) == usr.charAt(i)){
            st[i] = 1;
         }
      }
   }

   public boolean Is3strike() throws IOException{
      int sum=0;
      for (int i=0;i<st.length;i++){
         sum += st[i];
      }
      if (sum==3){
         bw.write(sum+ " 스트라이크" + "\n");
         return true;
      }
      else {
         return false;
      }
   }

   public void countBall(){
      for (int i=0;i<usr.length();++i){
         if (st[i]==0 && com.contains(String.valueOf(usr.charAt(i)))){
            ball[i] = 1;
         }
      }
   }
   public void countScore(){
      for (int i=0;i<usr.length();i++){
         stsum+= st[i];
         ballsum += ball[i];
      }
   }

   public void printScore() throws IOException{

      if (stsum!=0) {
         if (ballsum!=0){
            bw.write(stsum + " 스트라이크 " + ballsum + "볼" +"\n");
         } else{
            bw.write(stsum + " 스트라이크" + "\n");
         }
      } else {
         if (ballsum!=0){
            bw.write(ballsum+"볼" + "\n");
         } else{
            bw.write("낫싱" + "\n");
         }
      }
      bw.flush();

   }

   public void clearScore(){
      for (int i=0;i<usr.length();i++){
         st[i] = 0;
         ball[i]=0;
      }
      stsum=0;
      ballsum=0;
   }

   public boolean quitOrNot() throws IOException{

      bw.write("3개의 숫자를 모두 맞히셨습니다! 게임 종료" + "\n");
      bw.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요" + "\n");
      bw.flush();
      int choose = Integer.parseInt(br.readLine());
      if (choose == 2) {
         return true;
      }
      else {
         clearScore();
         return false;
      }
   }


   public static void main(String[] args) throws IOException {
      Baseball game = new Baseball();
      game.startGame();

   }


}
