public class Challenge_28 {

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for TreeNode with just value
        TreeNode(int val) {
            this.val = val;
        }

        // Constructor for TreeNode with value, left, and right children
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution class to check if the binary tree is symmetric
    public static class Solution {

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isMirror(root.left, root.right);
        }

        // Helper function to check if two subtrees are mirror images
        private boolean isMirror(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }

            return (left.val == right.val)
                    && isMirror(left.left, right.right)
                    && isMirror(left.right, right.left);
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test case 1: Symmetric tree
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                                          new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        Solution solution = new Solution();
        System.out.println("Is symmetric? " + solution.isSymmetric(root1));  // Output: true

        // Test case 2: Asymmetric tree
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)),
                                          new TreeNode(2, null, new TreeNode(3)));
        System.out.println("Is symmetric? " + solution.isSymmetric(root2));  // Output: false
    }
}
