public class ArrayDeque<T> {

    int size;
    T[] items;
    int nextFirst;
    int nextLast;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[]{null};
        nextFirst = 0;
        nextLast = 0;

    }

//    public ArrayDeque(ArrayDeque other) {
//        for (int i = 0; i < other.size(); i++) {
//            addLast(other.get(i));
//        }
//    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;

        if (nextFirst == 0 || nextFirst - nextLast == 1){
            int newSize = 3*items.length;
            resizeToBigger(newSize);
        }
        else{
            nextFirst --;
        }
    }

    /*
    what happens when resize to larger:
    resort everything
    add the same length to both the front, and the end
    nextFirst = size
    nextLast =  size * 2


    what happens when resize to smaller:
    - only do this when the data is of 1/9 size
    - only need to loop the data and start when the data is not null
    - no need to resort
    - resize it to the same, but add buffer to before and after

     */

    public void resizeToBigger(int newSize) {
        System.out.println("before resize to bigger");
        printDeque();
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i ++) {
            newItems[size + i] = items[i];
        }
        items = newItems;
        System.out.println("after resize to bigger");
        printDeque();
    }

    public void resizeToSmaller(int newSize) {
        System.out.println("before resize to smaller");
        printDeque();
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i ++) {
            newItems[i] = items[i];
        }
        items = newItems;
        System.out.println("after resize to smaller");
        printDeque();
    }

    public void addLast(T item) {
        size++;
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.print("[");
        for (int i = 0; i < items.length; i ++ ) {
            System.out.print(items[i] + ", ");
        }
        System.out.print("]");
        System.out.println("");
    }

    public T removeFirst() {
        size --;
        return null;
    }

    public T removeLast() {
        size --;
        return null;
    }

    public T get(int index) {
        return null;
    }

}
