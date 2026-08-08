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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;

    }
    public void inorder(TreeNode node, List<Integer> result){
        if (node == null) return;
        inorder(node.left, result);   // 1. go left, all the way down
        result.add(node.val);          // 2. process current node
        inorder(node.right, result);  // 3. go right
            
    }
}