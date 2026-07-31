class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> ans=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            ans.put(nums[i], ans.getOrDefault(nums[i], 0) + 1);
        }
        int res=0;
        for(int key: ans.keySet()){
            if(ans.get(key)>(n/2))
            res=key;
        }
        return res;
    }
}