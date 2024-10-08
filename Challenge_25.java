public class Challenge_25 {

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for TreeNode with just value
        TreeNode() {
        }

        // Constructor for TreeNode with value
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

    // Solution class to check if the binary tree is a valid BST
    public static class Solution {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        // Helper method to validate the BST
        private boolean isValidBST(TreeNode node, Integer min, Integer max) {
            if (node == null) {
                return true;
            }

            // Check if the node's value violates the min/max constraint
            if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
                return false;
            }

            // Recursively validate left and right subtrees
            return isValidBST(node.left, min, node.val) &&
                   isValidBST(node.right, node.val, max);
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        boolean isValid = solution.isValidBST(root);

        System.out.println("Is valid BST: " + isValid);  // Output: true
    }
}

