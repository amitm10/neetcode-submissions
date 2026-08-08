class Solution {
    private int preIdx = 0;
    private Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preIdx++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, inMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inMap.get(rootValue) + 1, right);
        return root;
    }
}