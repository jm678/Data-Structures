import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void offByOne() {
        for (int i = 33; i < 126; i += 1) {
            char x = (char) i;
            char y = (char) (i + 1);
            assertTrue(offByOne.equalChars(x, y));
            assertTrue(offByOne.equalChars(y, x));
            System.out.println(x + " " + y);
        }

        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('C', 'b'));
        assertFalse(offByOne.equalChars('a', 'c'));
    }

}
