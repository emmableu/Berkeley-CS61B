public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        return dequeIsPalindrome(d);
    }

    public boolean dequeIsPalindrome(Deque<Character> d){
        if (d.size() <= 1){
            return true;
        }

        Character f = d.removeFirst();
        Character l = d.removeLast();

        if (f != l) {
            return false;
        }
        return dequeIsPalindrome(d);

    }
}
