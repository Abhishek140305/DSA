class Solution {
    public int minimizeSum(int[] nums) {
        int[] smallest = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] largest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int value : nums) {
            if (value <= smallest[0]) {
                smallest[2] = smallest[1];
                smallest[1] = smallest[0];
                smallest[0] = value;
            } else if (value <= smallest[1]) {
                smallest[2] = smallest[1];
                smallest[1] = value;
            } else if (value <= smallest[2]) {
                smallest[2] = value;
            }

            if (value >= largest[0]) {
                largest[2] = largest[1];
                largest[1] = largest[0];
                largest[0] = value;
            } else if (value >= largest[1]) {
                largest[2] = largest[1];
                largest[1] = value;
            } else if (value >= largest[2]) {
                largest[2] = value;
            }
        }

        int removeTwoSmallest = largest[0] - smallest[2];
        int removeTwoLargest = largest[2] - smallest[0];
        int removeOneFromEachEnd = largest[1] - smallest[1];

        return Math.min(removeTwoSmallest, Math.min(removeTwoLargest, removeOneFromEachEnd));
    }
}