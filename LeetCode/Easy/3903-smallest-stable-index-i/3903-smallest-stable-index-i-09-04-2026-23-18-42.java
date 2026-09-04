import java.util.*;
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int c=Integer.MAX_VALUE;
        int l,s;
        l=0;
        for(int i=0;i<nums.length;i++){
            l=Math.max(l,nums[i]);
            s=Integer.MAX_VALUE;
            for(int j=i;j<nums.length;j++){
                s=Math.min(s,nums[j]);
            }
            if((l-s)<=k)
                c=Math.min(c,i);
        }
        if(c==Integer.MAX_VALUE)
            return -1;
        
        return c;
    }
}