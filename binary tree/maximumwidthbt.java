import java.util.LinkedList;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
    }
}
class maximumwidthbt {
    public int MaxWidth(TreeNode a){
        int max=Integer.MIN_VALUE;
        if(a==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        //int count=0;
        q.offer(a);
        while(!q.isEmpty()){
            int cursize=q.size();
            // count++;
            max=Math.max(cursize,max);
            //System.out.println(cur);
            for (int i = 0; i < cursize; i++) {
                TreeNode cur=q.poll();
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        a.left=new TreeNode(2);
        a.right=new TreeNode(3);
        a.left.left=new TreeNode(5);
        a.left.right=new TreeNode(6);
        a.right.right=new TreeNode(7);
        maximumwidthbt obj=new maximumwidthbt();
        int ans=obj.MaxWidth(a);
        System.out.print(ans);

    }
}
