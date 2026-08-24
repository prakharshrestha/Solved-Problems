class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> ans=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
        }
        int res=0;
        for(Map.Entry<Integer,Integer> e:ans.entrySet()){    
            if(e.getValue()==1)
            res=e.getKey();
        }
        return res;
    }
}