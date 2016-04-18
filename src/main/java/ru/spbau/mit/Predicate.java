package ru.spbau.mit;

/**
 * Created by vbv on 21.03.16.
 */
interface Predicate<T> extends Function1<T, Boolean> {

    default <U extends T> Predicate<U> and(final Predicate<? super T> q) {
        return arg -> apply(arg) && q.apply(arg);
    }

    default <U extends T> Predicate<U> or(final Predicate<? super T> q) {
        return arg -> apply(arg) || q.apply(arg);
    }

    default <U extends T> Predicate<U> not() {
        return arg -> !apply(arg);
    }

    Predicate<Object> ALWAYS_TRUE = arg -> true;
    Predicate<Object> ALWAYS_FALSE = arg -> false;
}
