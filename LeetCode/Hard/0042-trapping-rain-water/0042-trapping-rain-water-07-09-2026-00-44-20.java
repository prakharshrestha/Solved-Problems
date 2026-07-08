class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] lm=new int[n];
        int[] rm=new int[n];

 
        int temp=0;
        for(int i=0;i<n;i++){
            lm[i]=temp;
            temp=Math.max(temp,height[i]);
        }
 
        temp=0;
        for(int i=n-1;i>=0;i--){
            rm[i]=temp;
            temp=Math.max(temp,height[i]);
        }
 
 
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.max(Math.min(lm[i],rm[i])-height[i],0);
        }
 
        return ans;
    }
}