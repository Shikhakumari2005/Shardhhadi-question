class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val){
        this.val=val;
    }
}
class lca{
    public TreeNode LCA(TreeNode a ,int p, int q){
        if(a==null) return null;
        if(a.val==p || a.val==q){
            return a;
        }
        TreeNode lN=LCA(a.left ,p,q);
        TreeNode RN=LCA(a.right ,p,q);
        if(lN!=null && RN!=null){
            return a;
        }else if(lN!=null){
            return lN;
        }else{
            return RN;
        } 
    }
    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        a.left=new TreeNode(2);
        a.right=new TreeNode(3);
        a.left.right=new TreeNode(4);
        a.left.left=new TreeNode(5);
        a.right.left=new TreeNode(6);
        a.right.right=new TreeNode(7);
        int p=4;
        int q=7;
        lca obi=new lca();
    //    obi.LCA(a,p,q);      //this only call ;
        TreeNode ans = obi.LCA(a,p,q);
        System.out.println(ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.right.val);
    }
    
}
