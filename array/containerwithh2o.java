public class containerwithh2o{
    public static int containerwithwater(int[] height){
        int maxarea=0;
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        int i=0;
        int j=height.length-1;
        while(i<j){
                int len=Math.min(height[i],height[j]);
                int w=j-i;
                int ans=len*w;
                maxarea=Math.max(ans,maxarea);
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
        }
        return maxarea;
    }
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.print(containerwithwater(height));
    }
}