package generics;

/**
 * A simplistic generic sequence
 * @professor Jean-Michel Busca
 * @author Harold
 * @param <E> the type of the elements in this sequence
 */
public class Sequence<E extends Comparable<E>> {

    private final Object[] elements;
    private int size;

    // constructor
    public Sequence() {
        elements = new Object[100];
        size = 0;
    }

    public int getSize() { return size; }

    public void add(E element) {
        // because list in java is limited, verify that we don't try to add
        // more elements than there is place in the list
        if (size >= elements.length) {
            throw new IllegalStateException();
        }
        // add element at index size and increments the size
        elements[size]= element;
        size += 1;
    }

    @SuppressWarnings("Duplicates")
    public boolean remove(Object element) {
        int i = 0;
        // look at what index element is
        while (i < size && !elements[i].equals(element)) {
            i += 1;
        }
        // return false in case we looped through whole list
        if (i >= size) {
            return false;
        }
        size -= 1;
        // remove element by displacing elements after element
        // to 1 index before
        while (i < size) {
            elements[i] = elements[i + 1];
        }
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        return (E) elements[index];
    }

    public E max() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        E max = (E) elements[0];

        for (int i = 1; i < size; i++) {
            if (max.compareTo((E) elements[i]) < 0) {

                max = (E) elements[i];
            }
        }
        return max;
    }

    // ? because we must be able to remove from a sequence of Numbers
    // elements from a sequence form Integers
    public boolean removeAll(Sequence<?> other) {
        boolean isModified = false;
        for (int i = 0; i < other.size; i++) {
            if (remove(other.get(i))) { // removes element at the same time
                isModified = true;
            }
        }
        return isModified;
    }


}
