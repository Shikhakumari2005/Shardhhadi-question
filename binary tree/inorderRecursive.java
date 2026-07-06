class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class inorderRecursive {

    public static void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.right.right = new TreeNode(14);

        inorder(root);
    }
}