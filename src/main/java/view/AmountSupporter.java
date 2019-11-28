package view;

import computer.result.Results;

@FunctionalInterface
public interface AmountSupporter {
    int getAmount(Results results);
}
