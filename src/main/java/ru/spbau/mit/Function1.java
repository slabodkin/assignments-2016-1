package ru.spbau.mit;

/**
 * Created by vbv on 21.03.16.
 */
public interface Function1<T, R> {
    R apply(T arg);

    default <R1> Function1<T, R1> compose(final Function1<? super R, R1> g) {
        return arg -> g.apply(apply(arg));
    }
}
