public class OffByN implements CharacterComparator {
    private int N;
    public OffByN(int N) {
        this.N = N;
    }
    public boolean equalChars(char x, char y) {
        int z = x - y;
        z = Math.abs(z);
        return z == N;

    }
}
