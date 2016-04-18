package ru.spbau.mit;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by vbv on 22.03.16.
 */
public class Function1Test {
    @Test
    public void test1() {
        Function1<Integer, Integer> plus1 = arg -> arg + 1;

        Function1<Number, Integer> minus1 = arg -> arg.intValue() - 1;

        final int x = 2;
        final int y = plus1.compose(minus1).apply(x);
        assertEquals(x, y);
    }
}
