public class NothingResult implements ComparedResult {
    @Override
    public void printMessage() {
        System.out.println("낫싱");
    }

    @Override
    public boolean isGameRunning() {
        return true;
    }
}
