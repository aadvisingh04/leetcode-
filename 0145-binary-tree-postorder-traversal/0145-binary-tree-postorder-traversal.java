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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        postOrder(root,arr);
        return arr;
    }
    public static void postOrder(TreeNode root, List<Integer> arr){
        if(root==null) return;

        postOrder(root.left,arr);
        postOrder(root.right,arr);
        arr.add(root.val);
    }
}

/*class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if(root==null){
            return list;
        }
            st1.push(root);
        while(!st1.isEmpty()){
            TreeNode curr = st1.pop();
            st2.push(curr);
           
            if(curr.left!=null){
                st1.push(curr.left);
            }
            if(curr.right!=null){
                st1.push(curr.right);
            }
        }
        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }
}
*/