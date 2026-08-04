class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int curr=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1!=nums[i+1]){
                solve(nums[i],nums[i+1],ans);
            }
        }
        return ans;
    }
    public void solve(int s, int l, List<Integer> ans){
        for(int i=s+1;i<l;i++){
            ans.add(i);
        }
    }
}