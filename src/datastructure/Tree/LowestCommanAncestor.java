package datastructure.Tree;

import leetcode.TreeNode;

public class LowestCommanAncestor {

  private TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) {
      return null;
    }

    if (node == p || node == q) {
      return node;
    }

    TreeNode leftNode = LCA(node.left, p, q);
    TreeNode rightNode = LCA(node.right, p, q);

    if (leftNode != null && rightNode != null) {
      return node;
    } else if (leftNode != null) {
      return leftNode;
    } else {
      return rightNode;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    // some edge case
    if (p == q) {
      return p;
    }

    if (p == null || q == null) {
      return null;
    }
    return LCA(root, p, q);
  }
}
