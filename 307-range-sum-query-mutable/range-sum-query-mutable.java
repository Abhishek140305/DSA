// Java

class NumArray {

    class Node {
        int sum;
        Node left;
        Node right;

        Node() {
            sum = 0;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        root = n > 0 ? buildST(nums, 0, n - 1) : null;
    }

    private Node buildST(int[] nums, int s, int e) {
        Node node = new Node();

        // Leaf node
        if (s == e) {
            node.sum = nums[s];
            return node;
        }

        int mid = s + (e - s) / 2;

        node.left = buildST(nums, s, mid);
        node.right = buildST(nums, mid + 1, e);

        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    public void update(int index, int val) {
        updateUtil(index, val, 0, n - 1, root);
    }

    private void updateUtil(int index, int val, int s, int e, Node node) {
        if (s == e) {
            node.sum = val;
            return;
        }

        int mid = s + (e - s) / 2;

        if (index <= mid) {
            updateUtil(index, val, s, mid, node.left);
        } else {
            updateUtil(index, val, mid + 1, e, node.right);
        }

        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int left, int right) {
        return sumUtil(left, right, 0, n - 1, root);
    }

    private int sumUtil(int qs, int qe, int s, int e, Node node) {
        // No overlap
        if (e < qs || s > qe) {
            return 0;
        }

        // Complete overlap
        if (qs <= s && e <= qe) {
            return node.sum;
        }

        // Partial overlap
        int mid = s + (e - s) / 2;

        int leftSum = sumUtil(qs, qe, s, mid, node.left);
        int rightSum = sumUtil(qs, qe, mid + 1, e, node.right);

        return leftSum + rightSum;
    }
}