public class BaseBall{
    private int numbers[] = new int[3];
    private Computer computer;
    BaseBall(){
        init();
    }
    public void init(){
        computer = new Computer();
    }
}