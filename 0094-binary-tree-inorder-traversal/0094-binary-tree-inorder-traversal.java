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
/*
 //RECURSIVE WAY
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root,arr);
        return arr;
    }

    public static void inOrder(TreeNode root, List<Integer> arr){
        if(root == null) return;

        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
    }
} */

//ITERATIVE WAY
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st  = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                break;
                }
                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
}

