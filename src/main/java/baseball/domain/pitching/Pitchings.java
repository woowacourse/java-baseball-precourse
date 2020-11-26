package baseball.domain.pitching;

import baseball.domain.pitching.exception.PitchingsDuplicateException;
import baseball.domain.pitching.exception.PitchingsInputNotDigitException;
import baseball.domain.pitching.exception.PitchingsSizeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.RandomUtils;

public class Pitchings {

    public static final int SIZE = 3;
    private static final String DELIMITER = "";
    private static final String ONLY_DIGIT_REGULAR = "^[0-9]*";

    private final List<Pitching> pitchings;

    private Pitchings(final List<Pitching> pitchings) {
        this.pitchings = pitchings;
    }

    public static Pitchings of(final Set<Pitching> value) {
        return of(new ArrayList<>(value));
    }

    public static Pitchings of(final List<Pitching> value) {
        validate(value);
        return new Pitchings(value);
    }

    private static void validate(final List<Pitching> value) {
        if (value.size() != SIZE) {
            throw new PitchingsSizeException(value);
        }

        final Set<Pitching> removedDuplicated = new HashSet<>(value);
        if (removedDuplicated.size() != SIZE) {
            throw new PitchingsDuplicateException(value);
        }
    }

    public static Pitchings of(final String value) {
        validate(value);
        String[] splitedValue = value.split(DELIMITER);
        List<Pitching> pitchings = Arrays.stream(splitedValue)
            .map(Pitching::of)
            .collect(Collectors.toList());

        return of(pitchings);
    }

    private static void validate(final String value) {
        if (!isOnlyDigit(value)) {
            throw new PitchingsInputNotDigitException(value);
        }

        if (value.length() != SIZE) {
            throw new PitchingsSizeException(value);
        }
    }

    private static boolean isOnlyDigit(final String value) {
        return value.matches(ONLY_DIGIT_REGULAR);
    }

    public static Pitchings random() {
        final HashSet<Pitching> pitchingSet = new HashSet<>(Pitchings.SIZE);
        while (pitchingSet.size() < Pitchings.SIZE) {
            final int randomValue = RandomUtils.nextInt(Pitching.MIN_VALUE, Pitching.MAX_VALUE);
            pitchingSet.add(Pitching.of(randomValue));
        }

        return Pitchings.of(pitchingSet);
    }

    public boolean match(Pitchings targetPitchings, int index) {
        final Pitching base = getPitching(index);
        final Pitching target = targetPitchings.getPitching(index);

        return base.equals(target);
    }

    public Pitching getPitching(int index) {
        return this.pitchings.get(index);
    }

    public boolean contains(Pitching target) {
        return this.pitchings.contains(target);
    }

    public List<Pitching> getPitchings() {
        return this.pitchings;
    }

    @Override
    public String toString() {
        return this.pitchings.stream()
            .map(Pitching::toString)
            .collect(Collectors.joining());
    }
}
