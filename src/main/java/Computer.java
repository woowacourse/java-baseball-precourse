public class Computer extends Player {

    private int strikes;
    private int balls;

    public Computer(int num_len){
        super(num_len);
        strikes = 0;
        balls = 0;
    }

    public boolean check_strikes(char one, int index){
        return one == nums[index];
    }

    public boolean check_balls(char one){
        for(char target:nums){
            if(one == target){
                return true;
            }
        }
        return false;
    }

    public int check_points(char[] threw){
        int i = 0;
        for(char tmp:threw){
        if(check_strikes(tmp, i)){
            strikes++;
        }else if(check_balls(tmp)){
            balls++;
        }
        i++;
    }
        if(strikes > 0){
        System.out.print(strikes + "스트라이크");
    }
        if (balls > 0) {
            System.out.print(balls + "볼");
        }else if(strikes == 0){
            System.out.print("낫싱");
        }
        System.out.print("\n");
        return strikes;
    }

}
