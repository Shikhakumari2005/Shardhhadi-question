
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class iterativeinorder {
    

    public static void inorder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            System.out.print(current.val + " ");

            current = current.right;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        inorder(root);
    }
}