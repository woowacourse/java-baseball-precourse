import java.lang.*;

/**
 * The type Pitcher.
 */
public class Pitcher {
    private static final int PITCHING_COUNT = 3;
    private int[] pitching;

    /**
     * Instantiates a new Pitcher.
     */
    public Pitcher() {
        pitching = new int[PITCHING_COUNT];

        for (int i = 0; i < PITCHING_COUNT; i++) {
            pitching[i] = 0;
        }
    }

    /**
     * Instantiates a new Pitcher.
     *
     * @param n the n
     */
    public Pitcher(int n) {
        pitching = new int[PITCHING_COUNT];
        for (int i = PITCHING_COUNT - 1; i >= 0; i--) {
            pitching[i] = n % 10;
            n /= 10;
        }
    }

    /**
     * Get pitching int [ ].
     *
     * @return the int [ ]
     */
    public int[] getPitching() {
        return pitching;
    }

    /**
     * Print pitching.
     */
    public void printPitching() {
        for (int i = 0; i < PITCHING_COUNT; i++) {
            System.out.print(pitching[i] + " ");
        }
        System.out.println();
    }
}
