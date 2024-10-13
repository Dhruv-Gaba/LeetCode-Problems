class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] range = { 0, Integer.MAX_VALUE };
        int[] indices = new int[k];
        while (true) {
            int currMin = Integer.MAX_VALUE, currMax = Integer.MIN_VALUE, minListIdx = 0;
            for (int i = 0; i < k; i++) {
                int val = nums.get(i).get(indices[i]);
                if (val < currMin) {
                    currMin = val;
                    minListIdx = i;
                }
                if (val > currMax) {
                    currMax = val;
                }
            }
            if (currMax - currMin < range[1] - range[0]) {
                range[0] = currMin;
                range[1] = currMax;
            }
            if (++indices[minListIdx] == nums.get(minListIdx).size()) {
                break;
            }
        }
        return range;
    }
}
