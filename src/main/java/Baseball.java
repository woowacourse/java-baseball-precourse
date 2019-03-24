import java.io.*;
import java.nio.Buffer;
import java.util.Random;

public class Baseball {

   String com;
   String usr;

   int[] st = new int[3];
   int[] ball = new int[3];
   int stsum;
   int ballsum;

   Random random = new Random();
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

   public void startGame() throws IOException{

      while(true){
         com = comRandom();
         boolean gameover = false;
         bw.write("숫자를 입력해주세요 : ");
         bw.write(com);
         bw.flush();

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
               break;
            }
         }
      }
   }

   public String comRandom(){
      int first = random.nextInt(9) + 1;
      int second = random.nextInt(9) + 1;
      int third = random.nextInt(9) + 1;
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

         /*
         if(st[i]==1) continue;                       //스트라이크는 제외하고 볼 카운트하기 위함
         else if (com.contains(String.valueOf(usr.charAt(i)))){
            ball[i] = 1;
         }*/

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
         }
         else{
            bw.write(stsum + " 스트라이크" + "\n");
         }
      }
      else {
         if (ballsum!=0){
            bw.write(ballsum+"볼" + "\n");
         }
         else{
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
