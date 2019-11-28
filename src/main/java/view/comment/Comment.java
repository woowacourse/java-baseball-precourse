package view.comment;

import computer.result.Results;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Comment {
    STRIKE(Results::hasStrike, "%d 스트라이크", Results::getStrikeAmount),
    BALL(Results::hasBall, "%d 볼", Results::getBallAmount);

    private static final String DELIMITER = " ";

    private final CommentSelector commentSelector;
    private final String format;
    private final AmountSupporter amountSupporter;

    Comment(CommentSelector commentSelector, String format, AmountSupporter amountSupporter) {
        this.commentSelector = commentSelector;
        this.format = format;
        this.amountSupporter = amountSupporter;
    }

    public static String getComment(Results results) {
        return Arrays.stream(values())
                .filter(view -> view.support(results))
                .map(view -> String.format(view.format, view.getAmount(results)))
                .collect(Collectors.joining(DELIMITER));
    }

    private boolean support(Results results) {
        return commentSelector.support(results);
    }

    private int getAmount(Results results) {
        return amountSupporter.getAmount(results);
    }

}
