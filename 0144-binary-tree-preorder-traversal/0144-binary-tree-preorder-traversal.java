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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        preOrder(root,arr);
        return arr;
    }

    public static void preOrder(TreeNode root,List<Integer> arr){
        if(root==null) return;

        arr.add(root.val);
        preOrder(root.left,arr);
        preOrder(root.right,arr);
    }
}

/*class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null) return list;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
            list.add(curr.val);
        }
        return list;
    }
}
*/