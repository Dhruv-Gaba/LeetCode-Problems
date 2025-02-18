class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while ((n - i - 1) * 26 >= k - 1) {
            sb.append("a");
            k--;
            i++;
        }
        if (k == 0)
            return sb.toString();
        sb.append((char) ('a' - 1 + k - ((n - i - 1) * 26)));
        i++;
        while (i < n) {
            sb.append("z");
            i++;
        }
        return sb.toString();
    }
}
