public class Human {
    private int[] humanNumArray;
    private int inputNum;

    public Human() {
        this.humanNumArray = new int[3];
    }

    public void setInputNum(int inputNum){
        this.inputNum = inputNum;
    }

    public int[] getHumanNumArray(){
        return humanNumArray;
    }
}
