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
    public boolean areEqualVal(TreeNode n1, TreeNode n2)
    {
        if(n1==null && n2==null)
        return true;
        else if(n1!=null && n2!=null && n1.val == n2.val)
        return true;
        else
        return false;
    }
    

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    Stack<TreeNode[]>st = new Stack<>();
    st.push(new TreeNode[]{root1, root2});

    while(!st.isEmpty())
    {
      TreeNode[] temp = st.pop();
      TreeNode n1 = temp[0], n2 = temp[1];
      if(n1==null & n2==null)
      continue;
      if(n1==null || n2==null) return false;
      if(n1.val!=n2.val) return false;

      if( areEqualVal(n1.left, n2.left) &&  areEqualVal(n1.right,n2.right))
      {
        st.push(new TreeNode[]{n1.left, n2.left});
        st.push(new TreeNode[]{n1.right, n2.right});
      }
      else if(areEqualVal(n1.left, n2.right) && areEqualVal(n1.right, n2.left))
      {
        st.push(new TreeNode[]{n1.left, n2.right});
        st.push(new TreeNode[]{n1.right, n2.left});
      }

      else
      return false;
    }

    return true;

    }
}