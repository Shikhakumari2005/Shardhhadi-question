class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class completebinary {

    TreeNode root;

    // ===================== INSERT =====================

    public TreeNode insert(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // ===================== SEARCH =====================

    public TreeNode search(TreeNode root, int key) {

        if (root == null || root.val == key)
            return root;

        if (key < root.val)
            return search(root.left, key);

        return search(root.right, key);
    }

    // ===================== DELETE =====================

    public TreeNode delete(TreeNode root, int key) {

        if (root == null)
            return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {

            // Case 1 : No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2 : One child
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            // Case 3 : Two children
            TreeNode successor = findMin(root.right);

            root.val = successor.val;

            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    // ===================== FIND MIN =====================

    public TreeNode findMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // ===================== FIND MAX =====================

    public TreeNode findMax(TreeNode root) {

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    // ===================== INORDER =====================

    public void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // ===================== PREORDER =====================

    public void preorder(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // ===================== POSTORDER =====================

    public void postorder(TreeNode root) {

        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // ===================== HEIGHT =====================

    public int height(TreeNode root) {

        if (root == null)
            return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // ===================== MAIN =====================

    public static void main(String[] args) {

        completebinary tree = new completebinary();

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr) {
            tree.root = tree.insert(tree.root, x);
        }

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.println();

        System.out.print("Preorder: ");
        tree.preorder(tree.root);

        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(tree.root);

        System.out.println();

        System.out.println("Height = " + tree.height(tree.root));

        TreeNode node = tree.search(tree.root, 40);

        if (node != null)
            System.out.println("40 Found");
        else
            System.out.println("40 Not Found");

        tree.root = tree.delete(tree.root, 50);

        System.out.print("After deleting 50: ");
        tree.inorder(tree.root);
    }
}