import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("1"));
        assertTrue(palindrome.isPalindrome("!"));
        assertTrue(palindrome.isPalindrome("bob"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome("poop"));
        assertTrue(palindrome.isPalindrome("civic"));
        assertFalse(palindrome.isPalindrome("joe"));
        assertFalse(palindrome.isPalindrome("your"));
        assertFalse(palindrome.isPalindrome("cigarettes"));
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("aA"));
        assertFalse(palindrome.isPalindrome("aaca"));
        assertFalse(palindrome.isPalindrome("aab"));
    }

    @Test
    public void testOffByOnePalindrome() {
        CharacterComparator comparator = new OffByOne();
        assertTrue(palindrome.isPalindrome("", comparator));
        assertTrue(palindrome.isPalindrome("a", comparator));
        assertTrue(palindrome.isPalindrome("1", comparator));
        assertTrue(palindrome.isPalindrome("!", comparator));
        assertTrue(palindrome.isPalindrome("ab", comparator));
        assertTrue(palindrome.isPalindrome("aab", comparator));
        assertTrue(palindrome.isPalindrome("acdb", comparator));
        assertFalse(palindrome.isPalindrome("aa", comparator));
        assertFalse(palindrome.isPalindrome("AA", comparator));
        assertFalse(palindrome.isPalindrome("aB", comparator));
        assertFalse(palindrome.isPalindrome("Ba", comparator));
        assertFalse(palindrome.isPalindrome("abc", comparator));
        assertFalse(palindrome.isPalindrome("1431", comparator));
    }
}
