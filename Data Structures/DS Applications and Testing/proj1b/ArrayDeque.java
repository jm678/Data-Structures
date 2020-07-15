public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        size = other.size;
        nextFirst = items.length - 1;
        nextLast = other.size;
        int firstIndex = other.nextFirst + 1;
        if (firstIndex == items.length) {
            firstIndex = 0;
        }
        int lastIndex = other.nextLast - 1;
        if (lastIndex < 0) {
            lastIndex = items.length - 1;
        }
        if (lastIndex > firstIndex) {
            System.arraycopy(other.items, firstIndex, items, 0, size);
        } else {
            System.arraycopy(other.items, firstIndex, items, 0, items.length - firstIndex);
            System.arraycopy(other.items, 0, items, items.length - firstIndex,
                    (firstIndex + size) % items.length);
        }
    }
    @Override
    public void addFirst(T item) {
        resize();
        items[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        size += 1;
    }

    private void resize() {
        int firstIndex = nextFirst + 1;
        if (firstIndex == items.length) {
            firstIndex = 0;
        }
        int lastIndex = nextLast - 1;
        if (lastIndex < 0) {
            lastIndex = items.length - 1;
        }
        if (size == items.length) {
            T[] newArray = (T[]) new Object[items.length * 2];
            if (lastIndex > firstIndex) {
                System.arraycopy(items, firstIndex, newArray, 0, size);
            } else {
                System.arraycopy(items, firstIndex, newArray, 0,
                        items.length - firstIndex);
                System.arraycopy(items, 0, newArray,
                        items.length - firstIndex, (firstIndex + size) % items.length);
            }
            items = newArray;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        if (size <= items.length * .25 && items.length > 8) {
            T[] newArray = (T[]) new Object[items.length / 2];
            if (lastIndex > firstIndex) {
                System.arraycopy(items, firstIndex, newArray, 0, size);
            } else {
                System.arraycopy(items, firstIndex, newArray, 0, items.length - firstIndex);
                System.arraycopy(items, 0, newArray, items.length - firstIndex,
                        (firstIndex + size) % items.length);
            }
            nextFirst = newArray.length - 1;
            nextLast = size;
            items = newArray;
        }
    }
    @Override
    public void addLast(T item) {
        resize();
        items[nextLast] = item;
        nextLast += 1;
        if (nextLast >= items.length) {
            nextLast = 0;
        }
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int firstIndex = nextFirst + 1;
        if (firstIndex == items.length) {
            firstIndex = 0;
        }
        int lastIndex = nextLast - 1;
        if (lastIndex < 0) {
            lastIndex = items.length - 1;
        }
        if (lastIndex > firstIndex) {
            for (int i = firstIndex; firstIndex <= lastIndex; i++) {
                System.out.print(items[i]);
            }
        } else {
            for (int i = firstIndex; i <= items.length; i++) {
                System.out.print(items[i]);
            }
            for (int i = 0; i < lastIndex; i++) {
                System.out.print(items[i]);
            }
        }
        System.out.println(" ");
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int firstIndex = nextFirst + 1;
        if (firstIndex == items.length) {
            firstIndex = 0;
        }
        size -= 1;
        nextFirst = firstIndex;
        T lastItem = items[firstIndex];
        resize();
        return lastItem;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int lastIndex = nextLast - 1;
        if (lastIndex < 0) {
            lastIndex = items.length - 1;
        }
        size -= 1;
        nextLast = lastIndex;
        T lastItem = items[lastIndex];
        resize();
        return lastItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int newIndex = (nextFirst + 1 + index) % items.length;
        return items[newIndex];
    }
}
