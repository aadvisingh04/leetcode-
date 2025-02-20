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
 class Pair{
    TreeNode node;
    int pos;
       Pair(TreeNode node,int pos){
        this.node=node;
        this.pos=pos;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        //level order

        while(!q.isEmpty()){
            int size=q.size();
            int first=0,last=0;
            int mmin = q.peek().pos;

            for(int i=0;i<size;i++){
                int curr = q.peek().pos-mmin;

                TreeNode node = q.peek().node;

                q.poll();
                if(i==0){
                    first=curr;
                }
                if(i==size-1){
                    last = curr;
                }

                if(node.left!=null){
                    q.add(new Pair(node.left,2*curr+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,2*curr+2));
                }
            }
            ans = Math.max(ans,last-first+1);

        }
        return ans;
    }
}