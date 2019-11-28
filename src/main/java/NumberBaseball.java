import sun.security.util.ManifestDigester;

class Rnum{
    int val=0;

    public void setRnum(){
        while (this.val<100){
            this.val = (int)(Math.random()*1000);
            System.out.println(val);
        }
    }
}



public class NumberBaseball {

    public static void main(String[] args) {
        Rnum answer = new Rnum();
        answer.setRnum();
        
    }

}
