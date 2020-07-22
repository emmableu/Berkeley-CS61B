import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    public static void main(String[] args) {
        // You must use this CharacterComparator and not instantiate
        // new ones, or the autograder might be upset.
        Boolean r = offByOne.equalChars('a', 'a');
        System.out.print("r: " + r);
    }

    //    ("r: "+ r);

    // Your tests go here.
}