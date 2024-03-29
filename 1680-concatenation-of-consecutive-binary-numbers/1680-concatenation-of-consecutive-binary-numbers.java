class Solution {
    public int concatenatedBinary(int n) {
        return (int) LongStream.range(1, n + 1).reduce(0, (sum, i) -> (sum * (int) Math.pow(2, Long.toBinaryString(i).length()) + i) % 1_000_000_007);
    }
}