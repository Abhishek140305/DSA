/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(sb.length() > 0) sb.append(',');
            if(node == null){ 
                sb.append('N');
            } else {
                sb.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;

        String[] p = data.split(",");
        if(p.length == 0 || p[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(p[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while(!q.isEmpty() && i < p.length) {
            TreeNode node = q.poll();

            if(i < p.length && !p[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(p[i]));
                node.left = left;
                q.offer(left);
            }
            i++;

            if(i < p.length && !p[i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(p[i]));
                node.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}