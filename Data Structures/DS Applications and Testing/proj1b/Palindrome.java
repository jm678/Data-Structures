
public class Palindrome {

    public boolean isPalindrome(String word) {
        return helper(wordToDeque(word));
    }
    private boolean helper(Deque<Character> deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else {
            boolean firstEqLast = deque.removeFirst() == deque.removeLast();
            return firstEqLast && helper(deque);
        }
    }



    public Deque<Character> wordToDeque(String word) {
        Deque<Character> x = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            x.addLast(word.charAt(i));
        }
        return x;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return helper(wordToDeque(word), cc);
    }
    private boolean helper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else {
            boolean firstEqLast = cc.equalChars(deque.removeFirst(), deque.removeLast());
            return firstEqLast && helper(deque, cc);
        }

    }


}
