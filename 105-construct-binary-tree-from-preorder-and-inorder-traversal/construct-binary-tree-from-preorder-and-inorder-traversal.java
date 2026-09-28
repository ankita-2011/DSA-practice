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

    private int[] preorder;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;

        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(0, 0, inorder.length - 1);
    }

    private TreeNode build(
            int preStart,
            int inStart,
            int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        int leftSize = rootIndex - inStart;

        root.left = build(
                preStart + 1,
                inStart,
                rootIndex - 1
        );

        root.right = build(
                preStart + 1 + leftSize,
                rootIndex + 1,
                inEnd
        );

        return root;
    }
}