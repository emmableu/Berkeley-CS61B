/** Performs some basic linked list tests. */
public class ArrayDequeTest {



    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addTest();
    }


    public static void addTest() {
        System.out.println("Running addFirstTest.");
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(5);
        l.addFirst(6);
        l.addFirst(13);
        l.addFirst(14);
        l.addFirst(15);
//        l.printDeque();


//        l.addLast(13);
//        l.addLast(14);
////        l.addLast(15);
////        l.addLast(16);
////        l.addLast(17);
////        l.addLast(18);
////        l.addLast(19);
//
//        int first = l.removeFirst();
//        int first2 = l.removeFirst();

        int first4 = l.get(3);
//        int first3 = l.removeLast();
//        int first4 = l.removeLast();
//        int first5 = l.removeLast();
//        int first6 = l.removeLast();
        System.out.println(first4);

        ArrayDeque l1 = new ArrayDeque(l);
        l1.printDeque();


    }



}