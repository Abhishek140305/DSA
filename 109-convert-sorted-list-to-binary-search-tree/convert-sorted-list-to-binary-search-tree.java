class Solution {

    ListNode current;

    public TreeNode helper(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode leftChild = helper(left, mid - 1);

        TreeNode root = new TreeNode(current.val);
        current = current.next;

        TreeNode rightChild = helper(mid + 1, right);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {

        current = head;

        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return helper(0, size - 1);
    }
}