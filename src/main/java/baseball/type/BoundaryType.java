package baseball.type;

public enum BoundaryType {
    MINIMUM_INDEX(0),
    MAXIMUM_INDEX(2),
    MINIMUM_FLAG(0),
    MAXIMUM_FLAG(9),
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(9),
    MINIMUM_ASCII(49),
    MAXIMUM_ASCII(57);

    private final int boundary;

    BoundaryType(int boundary) {
        this.boundary = boundary;
    }

    public int getBoundary() {
        return boundary;
    }
}
