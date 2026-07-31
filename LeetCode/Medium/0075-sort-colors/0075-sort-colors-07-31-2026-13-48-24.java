class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int[] count =new int[3];

        for(int i=0;i<n;i++){
            if(nums[i]==0)
            count[0]+=1;

            if(nums[i]==1)
            count[1]+=1;

            if(nums[i]==2)
            count[2]+=1;
        }
        for(int i=0;i<n;i++){
            if(i<count[0])
            nums[i]=0;
            else if(i<count[1]+count[0])
            nums[i]=1;
            else if(i<count[0]+count[1]+count[2])
            nums[i]=2;
        }
    }
}