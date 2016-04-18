package ru.spbau.mit;

/**
 * Created by vbv on 21.03.16.
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Collections {
    //private Collections() {}

    public static <T, R> List<R> map(Function1<? super T, R> f, Iterable<T> col) {
        List<R> res = new ArrayList<>();
        for (T elt : col) {
            res.add(f.apply(elt));
        }
        return res;
    }

    public static <T> List filter(Predicate<? super T> p, Iterable<T> col) {
        List<T> res = new ArrayList<>();
        for (T elt : col) {
            if (p.apply(elt)) {
                res.add(elt);
            }
        }
        return res;
    }

    public static <T> List<T> takeWhile(Predicate<? super T> p, Iterable<T> col) {
        List<T> res = new ArrayList<>();
        for (T elt : col) {
            if (!p.apply(elt)) {
                break;
            } else {
                res.add(elt);
            }
        }
        return res;
    }

    public static <T> List<T> takeUnless(Predicate<? super T> p, Iterable<T> col) {
        return takeWhile(p.not(), col);
    }

    public static <R1 extends R, T, R> R foldl(Function2<R1, ? super T, R1> f,
                                               R1 start, Iterable<T> col) {
        for (T elt : col) {
            R1 tmp = f.apply(start, elt);
            start = tmp;
        }
        return start;
    }

    public static <R1 extends R, T, R> R foldr(Function2<? super T, R1, R1>
                                                       f, R1 start, Iterable<T> col) {
        //reversed arguments of f
        List<T> assessoir = new ArrayList<>();
        for (T elt : col) {
            assessoir.add(elt);
        }
        for (int i = assessoir.size() - 1; i >= 0; i--) {
            start = f.apply(assessoir.get(i), start);
        }
        return start;
    }
}
