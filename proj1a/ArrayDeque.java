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

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        for (int i = 0; i < other.items.length; i++) {
            items[i] = (T) other.items[i];
        }
        size = other.size;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;

        if (nextFirst == nextLast){
            int newSize = 3*size;
            resizeToBigger(newSize);
        }

        else if (nextFirst == 0){
            nextFirst = items.length - 1;
        }

        else{
            nextFirst --;
        }
        System.out.print("after add first: ");
        printDeque();
    }
    public void addLast(T item) {
        items[nextLast] = item;
        size++;

        if (nextFirst == nextLast){
            int newSize = 3*size;
            resizeToBigger(newSize);
        }

        else if (nextLast == items.length - 1){
            nextLast = 0;
        }

        else{
            nextLast ++;
        }

        System.out.print("after add last: ");
        printDeque();
    }

    /*
    what happens when resize to larger:
    resort everything
    add the same length to both the front, and the end
    nextFirst = size
    nextLast =  size * 2


    what happens when resize to smaller:
    - only do this when the data is of 1/9 size
    - make it 1/3 size
    - only need to loop the data and start when the data is not null
    - no need to resort
    - resize it to the same, but add buffer to before and after

     */

    public void resizeToBigger(int newSize) {
        System.out.println("before resize to bigger");
        printDeque();
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i ++) {
            newItems[size + i] = items[(i + nextFirst)%size];
        }
        items = newItems;
        nextFirst = size - 1;
        nextLast = size*2;
        System.out.println("after resize to bigger");
        printDeque();
    }

    public void resizeToSmaller(int newSize) {
        System.out.println("before resize to smaller");
        printDeque();
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i ++) {
            newItems[size + i] = items[(i + nextFirst+1)%items.length];
        }
        items = newItems;
        nextFirst = size - 1;
        if (isEmpty()){
            nextFirst = 0;
        }
        nextLast = size*2;
        System.out.println("after resize to smaller");
        printDeque();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.print("size:" + size() + " ");
        System.out.print("[");
        for (int i = 0; i < items.length; i ++ ) {
            System.out.print(items[i] + ", ");
        }
        System.out.print("] " + nextFirst + " " + nextLast);
        System.out.println("");
    }

    public T removeFirst() {
        int firstIndex = (nextFirst + 1)%items.length;
        T first = items[firstIndex];
        items[firstIndex] = null;
        size --;
        nextFirst = firstIndex;
        if (size <= items.length/9){
            resizeToSmaller(items.length/3);
        }
        printDeque();
        return first;
    }

    public T removeLast() {
        int lastIndex = (nextLast - 1)%items.length;
        T last = items[lastIndex];
        items[lastIndex] = null;
        size --;
        nextLast = lastIndex;
        if (size <= items.length/9){
            resizeToSmaller(items.length/3);
        }
        printDeque();
        return last;
    }

    public T get(int index) {
        return items[(index + nextFirst + 1)%items.length];
    }

}
