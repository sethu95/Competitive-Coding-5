// Time Complexity: O(n)
// Space Complexity: O(H)

// We recusively traverse the tree using DFS and keep track of the largest element at each level using a global result variable

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
    
    List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();

        largestValuesHelper(root, 0);

        return result;
    }

    public void largestValuesHelper(TreeNode root, int lvl) {
        if (root == null) return;

        int elem = root.val;

        if (result.size() == lvl) {
            // this is the first element for this level
            result.add(elem);
        } else {
            // we need to compare the existing element for this level
            result.set(lvl, Math.max(result.get(lvl), elem));
        }

        largestValuesHelper(root.left, lvl + 1);
        largestValuesHelper(root.right, lvl + 1);
    }
}
