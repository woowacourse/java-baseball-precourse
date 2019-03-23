public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.makeNum();


    }

}
class Computer{
    int firstNum,secondNum,thirdNum;

    
    public void makeNum(){
        do{
            firstNum = (int) (Math.random() * 8) + 1;
            secondNum = (int) (Math.random() * 8) + 1;
            thirdNum = (int) (Math.random() * 8) + 1;
        }while(firstNum == secondNum || thirdNum == secondNum || firstNum == thirdNum);
    }


}