class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        List<Long> sumsA = new ArrayList<>();
        List<Long> sumsB = new ArrayList<>();

        genSums(nums, 0, mid, 0L, sumsA);
        genSums(nums, mid, n, 0L, sumsB);

        Collections.sort(sumsA);
        Collections.sort(sumsB);

        int i = 0, j = sumsB.size() - 1;
        long best = Long.MAX_VALUE;

        while (i < sumsA.size() && j >= 0) {
            long s = sumsA.get(i) + sumsB.get(j);
            best = Math.min(best, Math.abs(s - goal));

            if (s < goal) i++;
            else if (s > goal) j--;
            else return 0;
        }
        return (int) best;
    }

    private void genSums(int[] nums, int start, int end, long cur, List<Long> out) {
        if (start == end) {
            out.add(cur);
            return;
        }
        genSums(nums, start + 1, end, cur, out);
        genSums(nums, start + 1, end, cur + nums[start], out);
    }
}