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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        int depth = 1;

        while(!temp.isEmpty()){
            int size = temp.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = temp.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }

            }
            depth ++;

        }
        return 0;
    }
}