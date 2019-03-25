public enum Cmd {
    NEWSTART("1"), EXIT("2");

    private String num;

    Cmd(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}
