package baseball;

public class Umpire {
    private final int ESSENTIAL_NUMBER_LENGTH = 3;
    private String computersNumber;
    private String usersNumber;

    public Umpire(String computersNumber) {
        this.computersNumber = computersNumber;
    }

    private boolean isNothing() {

        for (int i = 0; i < ESSENTIAL_NUMBER_LENGTH; i++) {
            String compareNumber = String.valueOf(usersNumber.charAt(i));

            if (computersNumber.contains(compareNumber)) {
                return false;
            }

        }

        return true;
    }
}
