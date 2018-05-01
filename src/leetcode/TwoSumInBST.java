package leetcode;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */

//Example 1:
// Input:
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7
//
// Target = 9
//
// Output: True
public class TwoSumInBST {

    private TreeNode root;

    private TreeNode binarySearch(TreeNode node, int t) {
        if (node == null)
            return null;

        if (node.val == t)
            return node;

        if (node.val < t) {
            return binarySearch(node.right, t);
        } else {
            return binarySearch(node.left, t);
        }
    }


    // for every node in BST, if we found targetNode is not null and not the node itself
    // we can return true. O(nlogn) time complexity
    private boolean inorder(TreeNode node, int t) {
        if (node == null)
            return false;

        boolean left = inorder(node.left, t);
        TreeNode targetNode = binarySearch(root, t - node.val);
        if (targetNode != null && targetNode != node) {
            return true;
        }
        boolean right = inorder(node.right, t);

        return left || right;
    }

    public boolean findTarget(TreeNode root, int k) {
        this.root = root;

        return inorder(root, k);
    }
}