// class Solution {

//     public  static boolean isValidBST(TreeNode root) {
//         return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     private  static boolean validate(TreeNode node, long min, long max) {

//         if (node == null)
//             return true;

//         if (node.val <= min || node.val >= max)
//             return false;

//         return validate(node.left, min, node.val)
//             && validate(node.right, node.val, max);
//     }
//     public static void main(String[] args) {
//         TreeNode a=new TreeNode(1);
//         a.left=new TreeNode(2);
//         a.right=new TreeNode(3);
//         a.left.right=new TreeNode(4);
//         a.left.left=new TreeNode(5);
//         a.right.left=new TreeNode(6);
//         a.right.right=new TreeNode(7);
//         // printTree(a);
//         System.out.println(isValidBST(TreeNode root));
//     }
// }