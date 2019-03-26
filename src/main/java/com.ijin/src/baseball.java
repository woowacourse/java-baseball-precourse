public class baseball {
    int num[];
    void RandomSave() {
        for (int i = 0; i < 3; i++)
            num[i] = ((int) Math.random() * 10) % 9 + 1;
    }

    public static void main(String[] args){
        baseball b = new baseball();
        b.RandomSave();
        for(int i=0;i<3;i++)
            System.out.println("%d", b.num[i]);
    }
}