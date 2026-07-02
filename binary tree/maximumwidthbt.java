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
class Pair {
    TreeNode node;
    long index;

    Pair(TreeNode node, long index) {
        this.node = node;
        this.index = index;
    }
}
class maximumwidthbt {
    public int MaxWidth(TreeNode root){
        // int max=Integer.MIN_VALUE;
        // if(a==null) return 0;
        // Queue<TreeNode> q=new LinkedList<>();
        // q.offer(a);
        // while(!q.isEmpty()){
        //     int cursize=q.size();
        //     max=Math.max(cursize,max);
        //     for (int i = 0; i < cursize; i++) {
        //         TreeNode cur=q.poll();
        //         if(cur.left!=null){
        //             q.offer(cur.left);
        //         }
        //         if(cur.right!=null){
        //             q.offer(cur.right);
        //         }
        //     }
        // }
        //return max;



        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 1));

        int ans = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            long first = q.peek().index;
            long last = first;

            for (int i = 0; i < size; i++) {

                Pair cur = q.poll();

                last = cur.index;

                if (cur.node.left != null)
                    q.offer(new Pair(cur.node.left, cur.index * 2));

                if (cur.node.right != null)
                    q.offer(new Pair(cur.node.right, cur.index * 2 + 1));
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }

        return ans;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(6);
        root.right.right=new TreeNode(7);
        maximumwidthbt obj=new maximumwidthbt();
        int ans=obj.MaxWidth(root);
        System.out.print(ans);

    }
}
