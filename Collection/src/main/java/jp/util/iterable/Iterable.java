package jp.util.iterable;
import java.util.function.Function;
import jp.util.iterator.Iterator;

public interface Iterable<E> {
    //For each element in the iterator, executes the specified action.
    public void forEach(Function<E, Void> action);

    //Gets an iterator over the elements in the iterator.
    public Iterator<E> iterator();
}
