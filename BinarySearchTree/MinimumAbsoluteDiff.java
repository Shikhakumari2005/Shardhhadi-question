class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MinimumAbsoluteDiff {

    static TreeNode prev = null;
    static int min = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {

        inorder(root);

        return min;
    }

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Process current node
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }

        prev = root;

        // Right
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(getMinimumDifference(root));
    }
}