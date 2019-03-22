import java.io.*;
import java.nio.Buffer;

public class Baseball {

   String com;
   String usr;

   int[] st = new int[3];
   int[] ball = new int[3];

   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

   public void startGame() throws IOException{

      while(true){
         int tmp = (int)(Math.random() * 1000) +1;
         com = String.valueOf(tmp);
         boolean gameover = false;
         bw.write(String.valueOf("숫자를 입력해주세요 : "));
         bw.write(com);
         bw.flush();
         //st,ball 을 계속 생성해버리면 주소가 다른 객체가 메모리에 계속 차임.
         //선언은 한번만하고, 나중에 void clear()를 만들어서 배열 청소해줄 것.
         while(true){
            usr = br.readLine();

            countStrike(com,usr,st);
            if(Is3strike(st)){
               gameover=true;
               break;
            }

            for (int i=0;i<com.length();++i){
               if(st[i]==1) continue;
               else if (com.contains(String.valueOf(usr.charAt(i)))){
                  ball[i] = 1;
               }
            }

            int stsum=0;
            int ballsum=0;

            for (int i=0;i<usr.length();i++){
               stsum += st[i];
               ballsum += ball[i];
            }
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

         if(gameover==true){
            bw.write("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            bw.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            bw.flush();
            int choose = Integer.parseInt(br.readLine());
            if (choose == 2) break;
            else {
               //void clear()
               for (int i=0;i<usr.length();i++){
                  st[i] = 0;
                  ball[i]=0;
               }
            }
         }
         bw.flush();
         //if 3 st 2while break;
         // -> 3개의 숫자를 모두 맞히셨습니다!! 게임 종료
         //gameover -> yes
         //choose -> 1,2
         //if choose ==2 break;



      }

   }

   public void countStrike(String com,String usr,int[] st){
      for (int i=0;i<com.length();++i){
         if (com.charAt(i) == usr.charAt(i)){
            st[i] = 1;
         }
      }
   }

   public boolean Is3strike(int[] st){
      int sum=0;
      for (int i=0;i<st.length;i++){
         sum += st[i];
      }
      if (sum==3){
         return true;
      }
      else {
         return false;
      }
   }

   public static void main(String[] args) throws IOException {
      Baseball game = new Baseball();
      game.startGame();

   }


}
