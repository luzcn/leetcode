package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only
// need to return the root node of any one of them.
//
// Two trees are duplicate if they have the same structure with same node values.
//
// Thoughts: The idea is in-order traverse the tree, but in-order sequence itself cannot guarantee a
// tree, so, we should use some special characters i.e. "(" and ")" to indicate the begin and end of
// a sub tree for example, the tree [1,2,3,4,3,2,4,null,null,null,null,4,3] will output the in-order
// sequence as (((4)2(3))1(((4)2(3))3(4)))
//
// each valid pair of "(" and ")" is a sub tree.
//
// use a hash map to save these strings.
// tree:[3,4] and tree[4,null,3] can be represented as
// ((3)4) and (3(4)) separately
public class FindDuplicateSubtrees {

  private Map<String, Integer> map = new HashMap<>();
  private List<TreeNode> result = new ArrayList<>();

  private String inorder(TreeNode node) {
    if (node == null) {
      return "";
    }

    String subtree = "(";
    subtree += inorder(node.left);

    subtree += Integer.toString(node.val);

    subtree += inorder(node.right);
    subtree += ")";

    // found duplicate, but we only need to report once.
    if (map.containsKey(subtree) && map.get(subtree) == 1) {
      result.add(node);
    }
    map.put(subtree, map.getOrDefault(subtree, 0) + 1);

    return subtree;
  }

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

    inorder(root);

    return this.result;
  }
}
