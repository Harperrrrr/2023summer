package BinaryTree;

import java.util.Arrays;

public class Serialize {
    String str;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return processSerialize(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        str = data;
        return processDeserialize();
    }

    public String processSerialize(TreeNode root) {
        if (root == null) {
            return "n";
        }
        return String.valueOf(root.val) + '_' + processSerialize(root.left) + '_' + processSerialize(root.right);
    }

    public TreeNode processDeserialize() {
        if (str.length() == 0) {
            return null;
        }
        String[] parts = str.split("_", 2);

        if (parts[0].equals("n")) {
            str = parts.length == 1 ? "" : parts[1];
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        str = parts[1];
        root.left = processDeserialize();
        root.right = processDeserialize();
        return root;
    }
}
