/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,TreeNode> map = new HashMap<>();
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    map.put(node.left.val,node);
                    q.add(node.left);
                }
                if(node.right!=null){
                    map.put(node.right.val,node);
                    q.add(node.right);
                }
            }
        }
        Map<Integer,Integer> visited =new HashMap<>();
        q.put(target);
        
        while (k > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                visited.put(node.val, 1);
                
                // Add left child if not visited.
                if (node.left != null && !visited.containsKey(node.left.val)) {
                    q.add(node.left);
                }
                
                // Add right child if not visited.
                if (node.right != null && !visited.containsKey(node.right.val)) {
                    queue.add(node.right);
                }
                
                // Add parent if not visited.
                if (map.containsKey(node.val) && !visited.containsKey(map.get(node.val).val)) {
                    q.add(map.get(node.val));
                }
            }
            k--;
        }

        // Step 3: Collect remaining nodes in the queue which are exactly distance K from target.
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }