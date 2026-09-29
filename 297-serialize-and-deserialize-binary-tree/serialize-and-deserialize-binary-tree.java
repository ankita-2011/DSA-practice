/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder result = new StringBuilder();

        serializeHelper(root, result);

        return result.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder result) {

        if (node == null) {
            result.append("#,");
            return;
        }

        result.append(node.val).append(",");

        serializeHelper(node.left, result);
        serializeHelper(node.right, result);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        int[] index = {0};

        return deserializeHelper(values, index);
    }

    private TreeNode deserializeHelper(
            String[] values,
            int[] index) {

        String value = values[index[0]++];

        if (value.equals("#")) {
            return null;
        }

        TreeNode node =
                new TreeNode(Integer.parseInt(value));

        node.left =
                deserializeHelper(values, index);

        node.right =
                deserializeHelper(values, index);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));