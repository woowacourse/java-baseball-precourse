package view;

import computer.result.Results;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ResultView {
    STRIKE(Results::hasStrike, "%d 스트라이크", Results::getStrikeAmount),
    BALL(Results::hasBall, "%d 볼", Results::getBallAmount);

    private static final String DELIMITER = " ";

    private final ViewSupporter viewSupporter;
    private final String comment;
    private final AmountSupporter amountSupporter;

    ResultView(ViewSupporter viewSupporter, String comment, AmountSupporter amountSupporter) {
        this.viewSupporter = viewSupporter;
        this.comment = comment;
        this.amountSupporter = amountSupporter;
    }

    public static String getComment(Results results) {
        return Arrays.stream(values())
                .filter(view -> view.support(results))
                .map(view -> String.format(view.comment, view.getAmount(results)))
                .collect(Collectors.joining(DELIMITER));
    }

    private boolean support(Results results) {
        return viewSupporter.support(results);
    }

    private int getAmount(Results results) {
        return amountSupporter.getAmount(results);
    }

}
