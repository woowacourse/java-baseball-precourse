package view.comment;

import computer.result.Results;

@FunctionalInterface
public interface AmountSupporter {
    int getAmount(Results results);
}
