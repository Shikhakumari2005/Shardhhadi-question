class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
    }
}
class searchinbst{

    public TreeNode searchBST(TreeNode root, int val) {

        // Base case
        if (root == null) {
            return null;
        }

        // Value found
        if (root.val == val) {
            return root;
        }

        // Search left
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // Search right
        return searchBST(root.right, val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        searchinbst a=new searchinbst();
        
        TreeNode result = a.searchBST(root, 10);

        if (result != null) {
            System.out.println("Found: " + result.val);
        } else {
            System.out.println("Not Found");
        }
    }
}
