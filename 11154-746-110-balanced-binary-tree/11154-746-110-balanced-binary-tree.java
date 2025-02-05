class Solution {
    
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    private BalanceInfo checkBalance(TreeNode root) {
        if (root == null) {
            return new BalanceInfo(true, 0); // A null tree is balanced with height 0
        }

        BalanceInfo leftSubtree = checkBalance(root.left);
        BalanceInfo rightSubtree = checkBalance(root.right);

        boolean isBalanced = leftSubtree.isBalanced && rightSubtree.isBalanced &&
                             Math.abs(leftSubtree.height - rightSubtree.height) <= 1;

        int height = 1 + Math.max(leftSubtree.height, rightSubtree.height);

        return new BalanceInfo(isBalanced, height);
    }

    private static class BalanceInfo {
        boolean isBalanced;
        int height;

        BalanceInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
