public class LinkedListDeque<T> implements Deque<T> {

    private class TNode {
        public T item;
        public TNode next;
        public TNode prev;

        public TNode (T i, TNode n, TNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(LinkedListDeque<T> other) {
        LinkedListDeque ours = new LinkedListDeque();
        TNode p = sentinel;
        TNode otherP = sentinel;
        for (int i = 0; i < other.size(); i++){
            p.next = otherP.next;
        }
    }

    @Override
    public void addFirst(T item) {
        TNode newNode = new TNode(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        TNode newNode = new TNode(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size = size + 1;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        TNode p = sentinel;
        for (int i = 0; i < size; i++){
            System.out.print(" " + p.next.item);
            p = p.next;
        }
        System.out.println("");
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T firstItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T lastItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return lastItem;
    }

    @Override
    public T get (int index) {
        TNode t = sentinel.next;
        for (int i = 0; i < index; i++){
            t = t.next;
            if (i == size - 1){
                return null;
            }
        }
        return t.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        TNode t = sentinel.next;
        return getRecursive(t, index);
    }

    public T getRecursive(TNode tNode, int index){
        if (index == 0) {
            return tNode.item;
        }
        tNode = tNode.next;
        return getRecursive(tNode, index - 1);
    }
}
