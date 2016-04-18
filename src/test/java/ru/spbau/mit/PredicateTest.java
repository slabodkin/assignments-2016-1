package ru.spbau.mit;


import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by vbv on 22.03.16.
 */
public class PredicateTest {
    @Test
    public void testAndOr() {
        Predicate<Integer> isEven = x -> x % 2 == 0;

        Predicate<Integer> isMoreThan1 = x -> x > 1;

        final int x = 3;
        final int y = 4;
        final int z = 1;
        final int t = 0;
        assertFalse(isEven.and(isMoreThan1).apply(x));
        assertFalse(isEven.and(isMoreThan1).apply(t));
        assertFalse(isEven.and(isMoreThan1).apply(z));
        assertTrue(isEven.and(isMoreThan1).apply(y));

        assertTrue(isEven.or(isMoreThan1).apply(x));
        assertTrue(isEven.or(isMoreThan1).apply(t));
        assertFalse(isEven.or(isMoreThan1).apply(z));
        assertTrue(isEven.or(isMoreThan1).apply(y));
    }

    @Test
    public void testNot() {
        Predicate<Integer> isEven = x -> x % 2 == 0;

        final int x = 3;
        assertTrue(isEven.not().apply(x));
    }

    @Test
    public void testConstants() {
        final int x = 1;
        assertTrue(Predicate.ALWAYS_TRUE.apply(x));
        assertFalse(Predicate.ALWAYS_FALSE.apply(x));
    }

    private static final Predicate<Integer> MUST_NOT_BE_CALLED =
            new Predicate<Integer>() {
        @Override
        public Boolean apply(Integer x) {
            throw new RuntimeException();
        }
    };

    @Test
    public void testAndOrSloth() {
        Predicate<Integer> isMoreThan1 = x -> x > 1;
        final int x = 3;
        isMoreThan1.or(MUST_NOT_BE_CALLED).apply(2);
        isMoreThan1.not().and(MUST_NOT_BE_CALLED).apply(2);

    }


}
