public class RandomNumber {
    private int randA;
    private int randB;
    private int randC;

    public void setRandomNum(){
        int a = makeRandomNum(), b = makeRandomNum(), c = makeRandomNum();
        while(true) {
            if (a != b && a != c && b != c){
                setRandA(a);
                setRandB(b);
                setRandC(c);
                break;
            }
            if (a == b) b = makeRandomNum();
            else if (c == a || c == b) c = makeRandomNum();
        }
    }

    public void setRandA(int a){
        this.randA = a;
    }
    public void setRandB(int b){
        this.randB = b;
    }
    public void setRandC(int c){
        this.randC = c;
    }

    public int getRandA(){
        return this.randA;
    }
    public int getRandB(){
        return this.randB;
    }
    public int getRandC(){
        return this.randC;
    }

    public int makeRandomNum(){
        return (int) (Math.random() * 9) + 1;
    }
}
