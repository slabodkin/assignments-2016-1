package ru.spbau.mit;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vbv on 22.03.16.
 */
public class CollectionsTest {

    @Test
    public void testMap() {
        Function1<Number, Integer> plus1 = x -> x.intValue() + 1;

        final List<Integer> toTest = new ArrayList<>(Arrays.asList(1, 2));

        List<Integer> toMap = Collections.map(plus1, toTest);
        final List<Integer> answer = Arrays.asList(2, 3);
        assertEquals(toMap, answer);
    }

    @Test
    public void testFilter() {
        Predicate<Number> isEven = x -> x.intValue() % 2 == 0;

        final List<Integer> toTest = new ArrayList<>(Arrays.asList(1, 2));

        List<Integer> toFilter = Collections.filter(isEven, toTest);
        assertEquals(toFilter, java.util.Collections.singletonList(2));
    }

    @Test
    public void testTakes() {
        final List<Integer> toTest = new ArrayList<Integer>(Arrays.asList(2, 6, 1));

        Predicate<Number> isEven = x -> x.intValue() % 2 == 0;

        final int threshold = 5;
        Predicate<Number> isMoreThan5 = x -> x.intValue() > threshold;

        List<Integer> toTakeWhile = Collections.takeWhile(isEven, toTest);
        final List<Integer> answer = Arrays.asList(2, 6);
        assertEquals(toTakeWhile, answer);

        List<Integer> toTakeUnless = Collections.takeUnless(isMoreThan5, toTest);
        assertEquals(toTakeUnless, java.util.Collections.singletonList(2));

        final List<Integer> toTestEmpty = java.util.Collections.emptyList();
        List<Integer> toTakeWhileFromEmpty = Collections.takeWhile(isEven, toTestEmpty);
        assertEquals(toTakeWhileFromEmpty, toTestEmpty);
    }

    @Test
    public void testFoldl() {
        Function2<String, Object, String> lConc = (x, y) -> x + y.toString();

        final ArrayList<String> toTest = new ArrayList<String>(Arrays.asList("a", "b"));

        final String foldled = Collections.foldl(lConc, "c", toTest);
        final String lAnswer = "cab";

        assertEquals(foldled, lAnswer);
    }

    @Test
    public void testFoldr() {
        Function2<Object, String, String> rConc = (x, y) -> x.toString() + y;

        final ArrayList<String> toTest = new ArrayList<String>(Arrays.asList("a", "b"));

        final String foldred = Collections.foldr(rConc, "c", toTest);
        final String rAnswer = "abc";

        assertEquals(foldred, rAnswer);
    }

}
