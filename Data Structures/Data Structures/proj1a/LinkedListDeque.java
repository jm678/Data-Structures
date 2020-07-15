public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * @source Josh hug's youtube video
     */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item) {
        sentinel.next.prev = new Node(item, sentinel.next, sentinel);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new Node(item, sentinel, sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(" ");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T dummy = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return dummy;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T dummy = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return dummy;
        }
    }

    public T get(int index) {
        if (index < 0) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0 && p != sentinel) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0) {
            return null;
        }
        return helper(index, sentinel.next);
    }

    private T helper(int index, Node currentNode) {
        if (currentNode == sentinel) {
            return null;
        } else if (index == 0) {
            return currentNode.item;
        } else {
            return helper(index - 1, currentNode.next);
        }
    }
}
