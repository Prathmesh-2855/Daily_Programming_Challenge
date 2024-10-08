public class Challenge_24 {

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for creating a new node
        TreeNode(int x) {
            val = x;
        }
    }

    // Solution class to find the lowest common ancestor
    public static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // If root is null, or root is one of the nodes, return root
            if (root == null || root == p || root == q) {
                return root;
            }

            // Recursively search in the left and right subtrees
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // If both left and right are not null, this is the LCA
            if (left != null && right != null) {
                return root;
            }

            // Otherwise, return the non-null result
            return left != null ? left : right;
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating a test binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;  // Node with value 5
        TreeNode q = root.left.right.right;  // Node with value 4

        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + lca.val);  // Output: 5
    }
}

