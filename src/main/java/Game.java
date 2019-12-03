public class Game {

    private boolean status;
    private int num_len;
    private User user;
    private Computer com;

    public Game(int num_len){
        this.num_len = num_len;
        status = true;
        user = new User(this.num_len);
        com = new Computer(this.num_len);
    }

    public void playBaseball(){
        boolean input = true;
        while(input){
            input = com.getNumber();
        }
        while(status){
            input = true;
            while (input){
                input = user.getNumber();
            }
            int strikes = com.check_points(user.nums);
            if(strikes == num_len){
                status = false;
            }
        }
    }
}
