class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int w = d + 1;  // two values in one bucket are at most d apart
        Map<Integer, int[]> box = new HashMap<>();  // smallest and largest b in each bucket
        for (int b : arr2)
            box.merge(Math.floorDiv(b, w), new int[]{b, b}, (x, y) -> new int[]{Math.min(x[0], y[0]), Math.max(x[1], y[1])});
        return (int) Arrays.stream(arr1).filter(a -> {  // own bucket empty, neighbours' closest values out of reach
            int k = Math.floorDiv(a, w);
            int[] left = box.get(k - 1), right = box.get(k + 1);
            return !box.containsKey(k) && (left == null || left[1] < a - d) && (right == null || right[0] > a + d);
        }).count();
    }
}