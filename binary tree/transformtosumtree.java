


class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val){
        this.val=val;
    }
}
public class transformtosumtree {
    public  static void printTree(TreeNode a) {
        if (a == null) {
            return;
        }
    
        System.out.println(a.val + " ");
        printTree(a.left);
        printTree(a.right);
    }
        
    public static int tranform(TreeNode a){
        if(a==null){
            return 0;
        }
        int lN=tranform(a.left);
        int RN=tranform(a.right);
        int oldValue = a.val;
         a.val = lN + RN;
        return oldValue + lN + RN;

    }
    
    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        a.left=new TreeNode(2);
        a.right=new TreeNode(3);
        a.left.right=new TreeNode(4);
        a.left.left=new TreeNode(5);
        a.right.left=new TreeNode(6);
        a.right.right=new TreeNode(7);
        printTree(a);
        System.out.println(tranform(a));
    }
    
}
