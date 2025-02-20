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
    class Pair{
        TreeNode node;
        int level;
          Pair(TreeNode node, int level){
             this.level=level;
             this.node=node;
          }
    }
    public List<Integer> rightSideView(TreeNode root) {
          List<Integer> ans = new ArrayList<>();

          if(root==null) return ans;

          TreeMap<Integer,Integer> map = new TreeMap<>();
          Queue<Pair> q = new LinkedList<>();
          q.add(new Pair(root,0));

          while(!q.isEmpty()){
              Pair p = q.poll();
              TreeNode node = p.node;
              int level = p.level;

              if(!map.containsKey(level)){
                map.put(level,node.val);
              }
              if(node.right!=null){
                 q.add(new Pair(node.right,level+1));
              }
              if(node.left!=null){
                 q.add(new Pair(node.left,level+1));
              }
          }
          for(int node:map.keySet()){
            ans.add(map.get(node));
          }
          return ans;
    }
}