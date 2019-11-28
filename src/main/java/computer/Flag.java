package computer;

import java.util.Objects;

public class Flag {
    private static final int NOT_END = 1;
    private static final int END = 2;

    private final boolean runnable;

    public Flag(int input) {
        if (input == END) {
            this.runnable = false;
            return;
        }
        this.runnable = true;
    }

    public static Flag init() {
        return new Flag(NOT_END);
    }

    public boolean isRunnable() {
        return runnable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flag flag = (Flag) o;
        return runnable == flag.runnable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(runnable);
    }
}
