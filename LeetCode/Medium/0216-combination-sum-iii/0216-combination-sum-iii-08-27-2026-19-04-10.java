class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        int[] nums=new int[9];
        for(int i=0;i<9;i++){
            nums[i]=i+1;
        }
        solve(ans,temp,nums,k,n,0);
        return ans;
    }
    public void solve(List<List<Integer>> ans,List<Integer> temp, int[] nums,int k,int n,int ind){
        if(n==0 && temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1])
            continue;

            if(nums[i]>n)
            break;

            temp.add(nums[i]);
            solve(ans,temp,nums,k,n-nums[i],i+1);
            temp.remove(temp.size()-1);
        }
    }
}