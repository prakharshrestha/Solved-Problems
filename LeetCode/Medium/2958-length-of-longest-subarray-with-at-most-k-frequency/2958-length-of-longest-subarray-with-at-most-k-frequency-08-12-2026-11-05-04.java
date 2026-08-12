class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> freq=new HashMap<>();
        int l=0,ans=0;

        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);

            while(freq.get(nums[i])>k){
                freq.put(nums[l],freq.get(nums[l])-1);
                l++;
            }
            ans=Math.max(ans,i-l+1);
        }
        return ans;
       
    }
}