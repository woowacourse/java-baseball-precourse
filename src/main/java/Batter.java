import java.util.HashSet;

class Batter {
    private HashSet<Integer> batting;

    public Batter(){
        batting = new HashSet<>();
        while(batting.size() != 3){
            Integer tmp = (int)(Math.random()*9+1);
            batting.add(tmp);
        }
    }
    public void printBatting(){
        for (Integer tmp : batting) {
            System.out.print(tmp);
        }
    }
}
