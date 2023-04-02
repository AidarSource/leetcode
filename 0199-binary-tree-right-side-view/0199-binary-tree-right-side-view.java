/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        bfs(res, root);

        return res;
    }

    private void bfs(List<Integer> list, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            for(int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                if(i == 0) list.add(curr.val);
                if(curr.right != null) queue.offer(curr.right);
                if(curr.left != null) queue.offer(curr.left);
            }
        }
    }
}