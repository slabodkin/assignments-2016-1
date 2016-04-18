package ru.spbau.mit;

/**
 * Created by vbv on 21.03.16.
 */
public interface Function2<T1, T2, R> {
    R apply(T1 arg1, T2 arg2);

    default <R1> Function2<T1, T2, R1> compose(final Function1<? super R, R1> g) {
        return (arg1, arg2) -> g.apply(apply(arg1, arg2));
    }

    default Function1<T2, R> bind1(T1 arg1) {
        return arg2 -> apply(arg1, arg2);
    }

    default Function1<T1, R> bind2(T2 arg2) {
        return arg1 -> apply(arg1, arg2);
    }

    default <U1 extends T1, U2 extends T2> Function1<U1, Function1<U2, R>> curry() {
        return arg1 -> arg2 -> apply(arg1, arg2);
    }

}
