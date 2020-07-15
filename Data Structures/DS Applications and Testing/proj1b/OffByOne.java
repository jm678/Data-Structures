public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int z = x - y;
        z = Math.abs(z);
        return z == 1;
    }

}

