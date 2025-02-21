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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder==null || preorder==null || inorder.length!=preorder.length){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,preorder.length-1,map);
    }
    private TreeNode build(int[] preorder,int ps,int pe,int[] inorder,int is, int ie,HashMap<Integer,Integer> map){
        if(ps>pe || is>ie){
            return null;
        }
        TreeNode root= new TreeNode(preorder[ps]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot-is;

        root.left = build(preorder,ps+1,ps+numLeft,inorder,is,inRoot-1,map);
        root.right = build(preorder,ps+numLeft+1,pe,inorder,inRoot+1,ie,map);

        return root;
    }
}