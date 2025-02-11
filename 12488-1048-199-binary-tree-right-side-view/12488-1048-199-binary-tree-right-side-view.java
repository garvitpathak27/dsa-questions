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
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        while(!temp.isEmpty()){
            int levelsize = temp.size();
            Integer lastVal = null;
            for(int i = 0 ; i < levelsize ; i++){
                TreeNode node = temp.poll();
                lastVal = node.val;
                if(node.left != null) temp.add(node.left);
                if(node.right != null) temp.add(node.right);

            }
            ans.add(lastVal);
        }
        return ans;
    }
}